package com.example.project2fromtemplate.ui.OneMovie;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.project2fromtemplate.databinding.FragmentOneMovieBinding;

public class OneMovieFragment extends Fragment {

    private int movieNumber;
    private FragmentOneMovieBinding binding;

    public static OneMovieFragment newInstance() {
        return new OneMovieFragment();
    }

    public void setMovieNumber(int i) {
        movieNumber = i;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        OneMovieViewModel oneMovieViewModel =
                new ViewModelProvider(this).get(OneMovieViewModel.class);
        oneMovieViewModel.update(movieNumber);
        binding = FragmentOneMovieBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textTitleView = binding.titleText;
        oneMovieViewModel.getTitleText().observe(getViewLifecycleOwner(), textTitleView::setText);

        final ImageView imageView = binding.largeImage;
        oneMovieViewModel.getImage().observe(getViewLifecycleOwner(), imageView::setImageResource);

        final TextView textDescriptionView = binding.description;
        oneMovieViewModel.getDescription().observe(getViewLifecycleOwner(), textDescriptionView::setText);

        final TextView textYear = binding.yearText;
        oneMovieViewModel.getYear().observe(getViewLifecycleOwner(), textYear::setText);

        final RatingBar ratingStars = binding.movieRating;
        oneMovieViewModel.getRating().observe(getViewLifecycleOwner(), ratingStars::setRating);

        final TextView textStaringActors = binding.staringActors;
        oneMovieViewModel.getActors().observe(getViewLifecycleOwner(), textStaringActors::setText);

        return root;
    }
        //OneMovieViewModel.getImage();//(getViewLifecycleOwner(), imageView::setImageResource);
        //imageView.setImageResource(R.drawable.avengers);
        //textView.setText("He's trying!");//.setImageResource(OneMovieViewModel.getImage());

/*    public static OneMovie newInstance(int i, String t, String y, float r, String d)
    {
        OneMovie movieDetailFragment = new OneMovie();
        Bundle args=new Bundle();
        args.putInt("id",i);
        args.putString("title",t);
        args.putString("year",y);
        args.putFloat("rating",r);
        args.putString("description", d);
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    } */

/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = new View(inflater.getContext());
        ImageView img = myView.findViewById(R.id.large_image);
        img.setImageResource(R.drawable.alice);
        return myView;
    } */
/*
    <EditText
        android:id="@+id/title_text"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintLeft_toRightOf="@id/large_image"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintHorizontal_weight="3"/>
    <EditText
        android:id="@+id/year_text"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintLeft_toRightOf="@id/large_image"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/title_text"
        app:layout_constraintHorizontal_weight="3"/>
    <LinearLayout
        android:id="@+id/rating_wrapper"
        android:layout_marginTop="10dp"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintLeft_toRightOf="@id/large_image"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/year_text">
        <RatingBar
        android:id="@+id/movie_rating"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:numStars="10"
        android:stepSize="1"
        style="@style/Base.Widget.AppCompat.RatingBar.Small"
                />
    </LinearLayout>
    <TextView
        android:id="@+id/description"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toBottomOf="@id/rating_wrapper"
        app:layout_constraintLeft_toRightOf="@id/large_image"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintBottom_toBottomOf="@id/large_image"/>
        setContentView(R.layout.fragment_one_movie);
        textView = findViewById(R.id.scoretext);
        seekBar = findViewById(R.id.seekBar);
    } */

/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        // inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_one_movie, container, false);
        ImageView imageView=v.findViewById(R.id.large_image);
        imageView.setImageResource(args.getInt("id"));
        EditText editText=v.findViewById(R.id.title_text);
        editText.setText(args.getString("title"));
        EditText yearText=v.findViewById(R.id.year_text);
        yearText.setText(args.getString("year"));
        RatingBar ratingBar=v.findViewById(R.id.movie_rating);
        ratingBar.setRating(args.getFloat("rating"));
        TextView descriptionText=v.findViewById(R.id.description);
        descriptionText.setText(args.getString("description"));
        return v;
    } */

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        OneMovieViewModel mViewModel = new ViewModelProvider(this).get(OneMovieViewModel.class);
        // TODO: Use the ViewModel
    }

}