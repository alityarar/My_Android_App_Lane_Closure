package com.example.yararalilaneclosure;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.List;

@SuppressWarnings("ALL")
public class Fragment1 extends Fragment implements Fragment2.DataAddedListener {

    private FragmentNavigationListener navigationListener;

    // Rest of the Fragment1 code

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentNavigationListener) {
            navigationListener = (FragmentNavigationListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FragmentNavigationListener");
        }
    }
    private LinearLayout containerLayout;
    private ButtonDatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        containerLayout = view.findViewById(R.id.containerLayout);
        databaseHelper = new ButtonDatabaseHelper(requireContext());
        updateLayouts();

        return view;
    }

    @Override
    public void onDataAdded() {

        updateLayouts();
    }
    public interface FragmentNavigationListener {
        void navigateToFragment2();
    }


    public void updateLayouts() {
        containerLayout.removeAllViews();

        List<Pair<String, String>> buttonNamesList = databaseHelper.getButtonNames();

        if (buttonNamesList.size() == 0) {
            showEmptyState();
        } else {
            for (Pair<String, String> buttonNames : buttonNamesList) {
                String firstName = buttonNames.first;
                String secondName = buttonNames.second;
                View layout = createLayout(firstName, secondName);
                containerLayout.addView(layout);
            }
        }
    }

    private View showEmptyState(){

        containerLayout.removeAllViews();
        View emptyStateLayout = LayoutInflater.from(requireContext()).inflate(R.layout.empty_layout, containerLayout, false);
      ImageView mg = emptyStateLayout.findViewById(R.id.mg);
      mg.setOnClickListener(v -> navigationListener.navigateToFragment2());
        containerLayout.addView(emptyStateLayout);
        return emptyStateLayout;
    }
    @SuppressLint("ResourceType")
    private View createLayout(String firstName, String secondName) {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View layout = inflater.inflate(R.layout.dynamic_layout, containerLayout, false);

        // Inside your method or class in an activity
        Drawable Shoulder = ContextCompat.getDrawable(getContext(), R.drawable.ic_shoulder);
        Drawable  Hov = ContextCompat.getDrawable(getContext(), R.drawable.ic_hov);
        Drawable Median = ContextCompat.getDrawable(getContext(), R.drawable.ic_median);
        Drawable Ramp = ContextCompat.getDrawable(getContext(), R.drawable.ic_ramp);
        Drawable Gore = ContextCompat.getDrawable(getContext(), R.drawable.ic_gore);
        Drawable Closed = ContextCompat.getDrawable(getContext(), R.drawable.ic_closed);
        Drawable Unknown = ContextCompat.getDrawable(getContext(), R.drawable.ic_unknown);
        Drawable Roling = ContextCompat.getDrawable(getContext(), R.drawable.ic_rolling);
        Drawable Blocked = ContextCompat.getDrawable(getContext(), R.drawable.ic_blocked);
        Drawable Alternating = ContextCompat.getDrawable(getContext(), R.drawable.ic_alternating);
        Drawable Intermittent = ContextCompat.getDrawable(getContext(), R.drawable.ic_intermittent);
        Drawable Lanes_Affected = ContextCompat.getDrawable(getContext(), R.drawable.ic_lanes_affected);





        TextView firstNameTextView = layout.findViewById(R.id.firstNameTextView);
        ImageButton deleteButton = layout.findViewById(R.id.deleteButton);
        ImageView firstImage = layout.findViewById(R.id.firstImage);
        ImageView secondImage = layout.findViewById(R.id.secondImage);


        if(firstName == null){
            if (secondName != null) {
                if (secondName.equals("Closed")) {
                    // Set drawable for Lanes_Affected
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_closed));
                } else if (secondName.equals("Unknown")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_unknown));
                }else if (secondName.equals("Rolling")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_rolling));
                }else if (secondName.equals("Blocked")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_blocked));
                }else if (secondName.equals("Alternating")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_alternating));
                }else if (secondName.equals("Intermittent")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_intermittent));
                } else {
                    // Set default drawable for firstName
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_lanes_affected));
                }
            }
            if(secondName == "Lanes_Affected"){
                secondName = "Lanes Affected";
            }
            firstNameTextView.setText(secondName);
        } else if (secondName == null) {

            if (firstName != null) {
                if (firstName.equals("Shoulder")) {
                    // Set drawable for Lanes_Affected
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_shoulder));
                } else if (firstName.equals("Hov")) {
                    // Set drawable for Some_Other_Name
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_hov));
                }else if (firstName.equals("Median")) {
                    // Set drawable for Some_Other_Name
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_median));
                }else if (firstName.equals("Ramp")) {
                    // Set drawable for Some_Other_Name
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_ramp));
                } else {
                    // Set default drawable for firstName
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_gore));
                }
            }

            if(firstName == "Lanes_Affected"){
                firstName = "Lanes Affected";
            }
            firstNameTextView.setText(firstName);
        } else{
            if (secondName != null) {
                if (secondName.equals("Closed")) {
                    // Set drawable for Lanes_Affected
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_closed));
                } else if (secondName.equals("Unknown")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_unknown));
                }else if (secondName.equals("Rolling")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_rolling));
                }else if (secondName.equals("Blocked")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_blocked));
                }else if (secondName.equals("Alternating")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_alternating));
                }else if (secondName.equals("Intermittent")) {
                    // Set drawable for Some_Other_Name
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_intermittent));
                } else {
                    // Set default drawable for firstName
                    secondImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_lanes_affected));
                }
            }

            if (firstName != null) {
                if (firstName.equals("Shoulder")) {
                    // Set drawable for Lanes_Affected
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_shoulder));
                } else if (firstName.equals("Hov")) {
                    // Set drawable for Some_Other_Name
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_hov));
                }else if (firstName.equals("Median")) {
                    // Set drawable for Some_Other_Name
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_median));
                }else if (firstName.equals("Ramp")) {
                    // Set drawable for Some_Other_Name
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_ramp));
                } else {
                    // Set default drawable for firstName
                    firstImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_gore));
                }
            }

            if(firstName == "Lanes_Affected"){
                firstName = "Lanes Affected";
            } else if (secondName == "Lanes_affected") {
                secondName = "Lanes Affected";
            }
            firstNameTextView.setText(firstName +", "+ secondName);

        }


        if("Lanes Affected" == firstName){
            firstName = "Lanes_Affected";
        }
        if("Lanes Affected" == secondName){
            secondName = "Lanes_Affected";
        }

        String finalSecondName = secondName;
        String finalFirstName = firstName;
        deleteButton.setOnClickListener(v -> {
            final String fName = finalFirstName;
            final String sName = finalSecondName;
            Log.d("DeleteButton", "Clicked: fName=" + fName + ", sName=" + sName);
            if (fName == null) {
                databaseHelper.deleteButtonNames(null, sName);
            } else if (sName == null) {
                databaseHelper.deleteButtonNames(fName, null);
            } else {
                databaseHelper.deleteButtonNames(fName, sName);
            }
            updateLayouts();
        });

        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        databaseHelper.close();
    }
}
