package com.tv.gallery;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class CustomRowsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.icon_row_item,
                container, false);
    }

    public void changePicture(int id){
        int drawableId = getView().getResources().getIdentifier(PictureList.PICTURE_NAMES[id],
                "drawable",
                getView().getContext().getPackageName());
        ImageView fullPicture = getView().findViewById(R.id.row_icon);
        fullPicture.setImageResource(drawableId);
    }
}
