package com.example.project2fromtemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.project2fromtemplate.ui.OneMovie.OneMovieFragment;
import com.example.project2fromtemplate.ui.home.HomeFragment;

import java.util.Map;

public class MovieViewer extends AppCompatActivity {
    private RecyclerView recycler_view;
    private MovieData md = new MovieData();
    private final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(md.getMoviesList());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_viewer);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recycler_view = (RecyclerView) findViewById(R.id.mainRecyclerView);
        // StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,5)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        recycler_view.setLayoutManager(layoutManager);
        recyclerViewAdapter.setOnItemClickListener(new OnListItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (getSupportActionBar() != null) {
                    getSupportActionBar().hide();
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                OneMovieFragment oneMovieFragment = OneMovieFragment.newInstance();
                oneMovieFragment.setMovieNumber(position);
                fragmentTransaction.replace(R.id.fullscreen, oneMovieFragment, null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                fragmentTransaction.commit();
            }

            @Override
            public void onItemLongClick(View v, int position) {

            }

        });
        recycler_view.setAdapter(recyclerViewAdapter);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Toast.makeText(getApplicationContext(), query, Toast.LENGTH_LONG).show();
                recyclerViewAdapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Toast.makeText(getApplicationContext(), newText, Toast.LENGTH_LONG).show();
                recyclerViewAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }
}
