package com.tv.gallery;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v17.leanback.app.HeadersFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowHeaderPresenter;
import android.view.KeyEvent;
import android.widget.AdapterView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;


public class CustomHeadersFragment extends HeadersFragment  {

    private ArrayObjectAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHeaderAdapter();
    }

    private void setHeaderAdapter() {
        adapter = new ArrayObjectAdapter();
        List<String> listPic = PictureList.setupPictures();
        Fragment rowFragment = ((MainActivity) getActivity()).getRowFragment();

        int id = 0;
        for (int i = 0; i < listPic.size(); i++) {
            HeaderItem header = new HeaderItem(id, PictureList.PICTURE_NAMES[i]);
            ArrayObjectAdapter innerAdapter = new ArrayObjectAdapter();
            innerAdapter.add(rowFragment);
            adapter.add(id, new ListRow(header, innerAdapter));
            id++;
        }

        setAdapter(adapter);
        setPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object item) {
                return new IconHeaderItemPresenter();
            }
    });

        setOnHeaderClickedListener(new HeadersFragment.OnHeaderClickedListener(){
            @Override
            public void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
                Object obj = ((ListRow) row).getAdapter().get(0);
                ((CustomRowsFragment) obj).changePicture((int)row.getId());
            }
        });

    }

    public void handleDPadrightAction(){
        Fragment rowFragment = ((MainActivity) getActivity()).getRowFragment();
        ((CustomRowsFragment)rowFragment).changePicture(getSelectedPosition());
    }

}
