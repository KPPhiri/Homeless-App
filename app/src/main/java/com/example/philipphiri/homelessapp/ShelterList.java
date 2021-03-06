package com.example.philipphiri.homelessapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * ShelterList class that creates a list
 * of appropriate shelters
 */

class ShelterList extends ArrayAdapter<Shelter>{
    private final Activity context;
    private final List<Shelter> shelterList;
    private List<Shelter> arraylist=null;

    /**
     * Shelterlist Activity
     * @param context context
     * @param shelterList list of Shelter objects
     */
    public ShelterList(Activity context, List<Shelter> shelterList) {
        super(context, R.layout.layout_shelter_list, shelterList);
        this.context = context;
        this.shelterList = new ArrayList<>(shelterList);

        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(shelterList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem;
        if (convertView == null) {
            listViewItem = inflater.inflate(R.layout.layout_shelter_list, null, true);
        } else {
            listViewItem = inflater.inflate(R.layout.layout_shelter_list, null, true);
        }
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewCapacity = listViewItem.findViewById(R.id.textViewCapacity);

        Shelter shelter = shelterList.get(position);
        textViewName.setText(shelter.getShelterName());
        textViewCapacity.setText(shelter.getShelterCapacity());

        return listViewItem;
    }

    /**
     * @param charText what to filter by
     */
    public void filter(String charText) {
        String Text;
        Text = charText.toLowerCase(Locale.getDefault());
        shelterList.clear();
        if (Text.isEmpty()) {
            shelterList.addAll(arraylist);
        }
        else
        {
            for (Shelter wp : arraylist) {
                if (wp.getShelterName().toLowerCase(Locale.getDefault()).contains(Text)) {
                    shelterList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    /**
     * @param option gender options
     */
    public void genFilter(CharSequence option) {
        shelterList.clear();
        {
            for (Shelter wp : arraylist) {
                if (wp.getShelterRestrictions().contains(option)) {
                    shelterList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    /**
     * @param option age options
     */
    public void ageFilter(CharSequence option) {
        shelterList.clear();
        {
            for (Shelter wp : arraylist) {
                if ((wp.getShelterRestrictions().contains(option))) {
                    shelterList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    /**
     * no filters
     */
    public void noFilter() {
        shelterList.clear();
        {
//            for (Shelter wp : arraylist) {
//                shelterList.add(wp);
//            }
            shelterList.addAll(arraylist);
        }
        notifyDataSetChanged();
    }


}
