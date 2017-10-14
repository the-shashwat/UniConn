package com.pat_041.android.uniconn;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.pat_041.android.uniconn.definitions.SuperObjects;
import com.pat_041.android.uniconn.networkingutils.CallAPIUtils;
import com.pat_041.android.uniconn.SearchCaseConstants;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ResultsLoader extends AsyncTaskLoader<List<? extends SuperObjects>> {


    private String query;
    private int searchCase;

    public ResultsLoader(Context context, String query, int searchCase) {
        super(context);
        this.query = query;
        this.searchCase = searchCase;
    }

    @Override
    public List<? extends SuperObjects> loadInBackground() {

        ArrayList<? extends SuperObjects> list = null;

        // call function here according to case
        try {
            switch (searchCase) {
                case SearchCaseConstants.NORMAL_COLLEGE_SEARCH:
                    list =  CallAPIUtils.getStandAloneObjects(1, query);
                    break;

            }
        } catch (JSONException e) {
            Log.e("ResultsLoader","Unable to get list");
        }

        return list;
    }
}
