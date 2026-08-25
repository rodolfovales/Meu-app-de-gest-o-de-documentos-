<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#F5F5F5">

    <TextView android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="🔑 PAINEL MASTER" android:textSize="20sp" android:textStyle="bold"
        android:padding="16dp" android:background="#1976D2" android:textColor="#FFFFFF"
        android:gravity="center"/>

    <TextView android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Todas as Empresas Cadastradas" android:textSize="15sp" android:textStyle="bold"
        android:padding="12dp" android:textColor="#333333"/>

    <ListView android:id="@+id/lista_empresas" android:layout_width="match_parent"
        android:layout_height="match_parent" android:divider="#E0E0E0" android:dividerHeight="1dp"/>

</LinearLayout>
    
