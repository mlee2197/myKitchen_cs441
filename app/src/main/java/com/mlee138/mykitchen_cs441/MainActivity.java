package com.mlee138.mykitchen_cs441;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    /*private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_kitchen:
                    mTextMessage.setText(R.string.title_kitchen);
                    setContentView(R.layout.kitchen_content);
                    return true;
                case R.id.navigation_recipes:
                    mTextMessage.setText(R.string.title_recipes);
                    setContentView(R.layout.recipes_content);
                    return true;
                case R.id.navigation_shoppinglist:
                    mTextMessage.setText(R.string.title_shoppinglist);
                    setContentView(R.layout.shoppinglist_content);
                    return true;
            }
            return false;
        }
    };*/

    KitchenFragment kitchenFragment = new KitchenFragment();
    RecipesFragment recipesFragment = new RecipesFragment();
    ShoppingListFragment shoppingListFragment = new ShoppingListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(kitchenFragment);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch(menuItem.getItemId()){
            case R.id.navigation_kitchen:
                fragment = kitchenFragment;
                break;

            case R.id.navigation_recipes:
                fragment = recipesFragment;
                break;

            case R.id.navigation_shoppinglist:
                fragment = shoppingListFragment;
                break;
        }
        return loadFragment(fragment);
    }
}
