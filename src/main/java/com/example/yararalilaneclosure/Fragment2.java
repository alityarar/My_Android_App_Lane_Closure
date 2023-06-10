package com.example.yararalilaneclosure;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.List;


@SuppressWarnings("ALL")
public class Fragment2 extends Fragment  {
    private RelativeLayout selectedRelativeLayout1;
    private RelativeLayout selectedRelativeLayout2;

    private ImageButton btn;
    private FragmentNavigationListener navigationListener;
    private ImageButton btn1;

    private ButtonDatabaseHelper databaseHelper;
    private DataAddedListener dataAddedListener;


    private void addDataToDatabase() {
        // Code to add data to the database

        if (dataAddedListener != null) {
            // Call the callback method in Fragment1
            dataAddedListener.onDataAdded();
        }
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DataAddedListener) {
            dataAddedListener = (DataAddedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement DataAddedListener");
        }
        if (context instanceof FragmentNavigationListener) {
            navigationListener = (FragmentNavigationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentNavigationListener");
        }
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        databaseHelper = new ButtonDatabaseHelper(getActivity());

        RelativeLayout shoulder = view.findViewById(R.id.Shoulder);
        RelativeLayout hov = view.findViewById(R.id.Hov);
        RelativeLayout median = view.findViewById(R.id.Median);
        RelativeLayout ramp = view.findViewById(R.id.Ramp);
        RelativeLayout gore = view.findViewById(R.id.Gore);


        ImageButton shoulde = view.findViewById(R.id.im1);
        ImageButton ho = view.findViewById(R.id.im2);
        ImageButton media = view.findViewById(R.id.im3);
        ImageButton ram = view.findViewById(R.id.im4);
        ImageButton gor = view.findViewById(R.id.im5);

        shoulder.setOnClickListener(v -> selectButton(shoulder, shoulde));
        hov.setOnClickListener(v -> selectButton(hov, ho));
        median.setOnClickListener(v -> selectButton(median, media));
        ramp.setOnClickListener(v -> selectButton(ramp, ram));
        gore.setOnClickListener(v -> selectButton(gore, gor));


        shoulde.setOnClickListener(v -> selectButton(shoulder, shoulde));
        ho.setOnClickListener(v -> selectButton(hov, ho));
        media.setOnClickListener(v -> selectButton(median, media));
        ram.setOnClickListener(v -> selectButton(ramp, ram));
        gor.setOnClickListener(v -> selectButton(gore, gor));

        TextView should = view.findViewById(R.id.tx1);
        TextView h = view.findViewById(R.id.tx2);
        TextView medi = view.findViewById(R.id.tx3);
        TextView ra = view.findViewById(R.id.tx4);
        TextView go = view.findViewById(R.id.tx5);

        should.setOnClickListener(v -> selectButton(shoulder, shoulde));
        h.setOnClickListener(v -> selectButton(hov, ho));
        medi.setOnClickListener(v -> selectButton(median, media));
        ra.setOnClickListener(v -> selectButton(ramp, ram));
        go.setOnClickListener(v -> selectButton(gore, gor));

        RelativeLayout closed = view.findViewById(R.id.Closed);
        RelativeLayout unknown = view.findViewById(R.id.Unknown);
        RelativeLayout rolling = view.findViewById(R.id.Rolling);
        RelativeLayout blocked = view.findViewById(R.id.Blocked);
        RelativeLayout alternating = view.findViewById(R.id.Alternating);
        RelativeLayout intermittent = view.findViewById(R.id.Intermittent);
        RelativeLayout lanesAffected = view.findViewById(R.id.Lanes_Affected);


        ImageButton close = view.findViewById(R.id.ima1);
        ImageButton unknow = view.findViewById(R.id.ima2);
        ImageButton rollin = view.findViewById(R.id.ima3);
        ImageButton blocke = view.findViewById(R.id.ima4);
        ImageButton alternatin = view.findViewById(R.id.ima5);
        ImageButton intermitten = view.findViewById(R.id.ima6);
        ImageButton lanesAffecte = view.findViewById(R.id.ima7);

        closed.setOnClickListener(v -> selectedButton(closed, close));
        unknown.setOnClickListener(v -> selectedButton(unknown, unknow));
        rolling.setOnClickListener(v -> selectedButton(rolling, rollin));
        blocked.setOnClickListener(v -> selectedButton(blocked, blocke));
        alternating.setOnClickListener(v -> selectedButton(alternating, alternatin));
        intermittent.setOnClickListener(v -> selectedButton(intermittent, intermitten));
        lanesAffected.setOnClickListener(v -> selectedButton(lanesAffected, lanesAffecte));


        close.setOnClickListener(v -> selectedButton(closed, close));
        unknow.setOnClickListener(v -> selectedButton(unknown, unknow));
        rollin.setOnClickListener(v -> selectedButton(rolling, rollin));
        blocke.setOnClickListener(v -> selectedButton(blocked, blocke));
        alternatin.setOnClickListener(v -> selectedButton(alternating, alternatin));
        intermitten.setOnClickListener(v -> selectedButton(intermittent, intermitten));
        lanesAffecte.setOnClickListener(v -> selectedButton(lanesAffected, lanesAffecte));

        TextView clos = view.findViewById(R.id.txa1);
        TextView unkno = view.findViewById(R.id.txa2);
        TextView rolli = view.findViewById(R.id.txa3);
        TextView block = view.findViewById(R.id.txa4);
        TextView alternati = view.findViewById(R.id.txa5);
        TextView intermitte = view.findViewById(R.id.txa6);
        TextView lanesAffect = view.findViewById(R.id.txa7);

        clos.setOnClickListener(v -> selectedButton(closed, close));
        unkno.setOnClickListener(v -> selectedButton(unknown, unknow));
        rolli.setOnClickListener(v -> selectedButton(rolling, rollin));
        block.setOnClickListener(v -> selectedButton(blocked, blocke));
        alternati.setOnClickListener(v -> selectedButton(alternating, alternatin));
        intermitte.setOnClickListener(v -> selectedButton(intermittent, intermitten));
        lanesAffect.setOnClickListener(v -> selectedButton(lanesAffected, lanesAffecte));

        Button saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> saveSelectedButtonData());

        Button cancelButton = view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v ->  navigationListener.navigateToFragment1());

        return view;
    }

    private void selectButton(RelativeLayout relativeLayout, ImageButton imageButton) {
        // Assuming you have an ImageButton called "imageButton"

        if (selectedRelativeLayout1 == relativeLayout) {
            // Clicked on the same button again, deselect it
            selectedRelativeLayout1.setSelected(false);
            selectedRelativeLayout1.setBackgroundResource(R.drawable.rounded_background);
            imageButton.setBackground(btn.getBackground());
            imageButton.setBackgroundTintList(null); // Remove the background tint

            selectedRelativeLayout1 = null;
        } else {
            if (selectedRelativeLayout1 != null) {
                // Reset the previously selected button
                selectedRelativeLayout1.setSelected(false);
                selectedRelativeLayout1.setBackgroundResource(R.drawable.rounded_background);
                btn.setBackground(btn.getBackground());
                btn.setBackgroundTintList(null);

            }

            selectedRelativeLayout1 = relativeLayout;
            btn = imageButton;
            selectedRelativeLayout1.setSelected(true);
            selectedRelativeLayout1.setBackgroundResource(R.drawable.roun);
            // Assuming you have an ImageButton instance called "imageButton"
            ColorStateList colorStateList = ColorStateList.valueOf(getResources().getColor(R.color.white));
            imageButton.setBackgroundTintList(colorStateList);


        }

    }


    private void selectedButton(RelativeLayout relativeLayout, ImageButton imageButton) {
        if (selectedRelativeLayout2 == relativeLayout) {
            // Clicked on the same button again, deselect it
            selectedRelativeLayout2.setSelected(false);
            selectedRelativeLayout2.setBackgroundResource(R.drawable.rounded_background);
            imageButton.setBackground(btn1.getBackground());
            imageButton.setBackgroundTintList(null); // Remove the background tint
            selectedRelativeLayout2 = null;
        } else {
            if (selectedRelativeLayout2 != null) {
                // Reset the previously selected button
                selectedRelativeLayout2.setSelected(false);
                selectedRelativeLayout2.setBackgroundResource(R.drawable.rounded_background);
                btn1.setBackground(btn1.getBackground());
                btn1.setBackgroundTintList(null);
            }

            selectedRelativeLayout2 = relativeLayout;
            btn1 = imageButton;
            selectedRelativeLayout2.setSelected(true);
            selectedRelativeLayout2.setBackgroundResource(R.drawable.roun);
            ColorStateList colorStateList = ColorStateList.valueOf(getResources().getColor(R.color.white));
            imageButton.setBackgroundTintList(colorStateList);

        }
    }

    private void saveSelectedButtonData() {
        if (selectedRelativeLayout1 != null || selectedRelativeLayout2 != null) {
            int buttonNumber1 = selectedRelativeLayout1 != null ? selectedRelativeLayout1.getId() : -1;
            int buttonNumber2 = selectedRelativeLayout2 != null ? selectedRelativeLayout2.getId() : -1;

            String buttonIdWithoutPackage1 = buttonNumber1 != -1 ? getResources().getResourceEntryName(buttonNumber1) : null;
            String buttonIdWithoutPackage2 = buttonNumber2 != -1 ? getResources().getResourceEntryName(buttonNumber2) : null;

            databaseHelper.insertButtonNames(buttonIdWithoutPackage1, buttonIdWithoutPackage2);

            // Store the button numbers in the database
            // Get the stored button numbers from the database
            List<Pair<String, String>> storedButtonNames = databaseHelper.getButtonNames();

            // Display the selected button numbers in a toast message
            StringBuilder message = new StringBuilder("Selected button numbers:");
                for (Pair<String, String> buttonNames : storedButtonNames) {
                    message.append(" ").append(buttonNames.first).append(" + ").append(buttonNames.second);
                }
            addDataToDatabase();

        } else {
            Toast.makeText(getContext(), "Nothing Added", Toast.LENGTH_SHORT).show();
        }
        navigationListener.navigateToFragment1();
    }

    public interface DataAddedListener {
        void onDataAdded();
    }
    public void setDataAddedListener(DataAddedListener listener) {
        dataAddedListener = listener;
    }

    private void navigateToFragment1() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            View parentView = parentFragment.getView();
            if (parentView != null) {
                ViewPager viewPager = parentView.findViewById(R.id.viewpager);
                if (viewPager != null) {
                    viewPager.setCurrentItem(0);
                }
            }
        }

    }


    public interface FragmentNavigationListener {
        void navigateToFragment1();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        databaseHelper.close();
    }}
