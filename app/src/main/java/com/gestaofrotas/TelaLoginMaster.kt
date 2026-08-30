package com.gestaofrotas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class TelaLoginMaster : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 9001

    // 🔑 E-mails autorizados a acessar o Painel Master — adicione quantos quiser!
    private val emailsAutorizados = listOf(
        "rodolfovales84@gmail.com"  // ← TROQUE PELO SEU E-MAIL
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_login_master)

        val btnEntrarGoogle = findViewById<Button>(R.id.btn_entrar_google)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        // Configurar Login Google
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        btnEntrarGoogle.setOnClickListener { fazerLogin() }
        btnVoltar.setOnClickListener { finish() }
    }

    private fun fazerLogin() {
        val intent = googleSignInClient.signInIntent
        startActivityForResult(intent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val conta = task.getResult(ApiException::class.java)
                loginComFirebase(conta)
            } catch (e: Exception) {
                Toast.makeText(this, "❌ Falha no login", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginComFirebase(conta: GoogleSignInAccount?) {
        conta?.let {
            val credencial = GoogleAuthProvider.getCredential(it.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credencial)
                .addOnSuccessListener { _ ->
                    val emailUsuario = it.email
                    if (emailsAutorizados.contains(emailUsuario)) {
                        Toast.makeText(this, "✅ Bem-vindo, $emailUsuario!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, PainelMaster::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "❌ Acesso não autorizado", Toast.LENGTH_SHORT).show()
                        FirebaseAuth.getInstance().signOut()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "❌ Erro: ${it.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
