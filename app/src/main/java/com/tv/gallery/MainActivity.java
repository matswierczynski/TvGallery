package com.tv.gallery;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;


public class MainActivity extends Activity{

    private CustomHeadersFragment headersFragment;
    private CustomRowsFragment rowsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        headersFragment = new CustomHeadersFragment();
        rowsFragment = new CustomRowsFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction
                .replace(R.id.header_container, headersFragment, "CustomHeadersFragment")
                .replace(R.id.rows_container, rowsFragment, "CustomRowsFragment");
        transaction.commit();

    }

    @Override
    public boolean onKeyUp (int keyCode,
                            KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
            headersFragment.handleDPadrightAction();

        return true;
    }

    public Fragment getRowFragment(){return rowsFragment;}

}
