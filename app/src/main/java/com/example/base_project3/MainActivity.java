package com.example.base_project3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    HomeActivity home;
    TeacherActivity teacher;
    StudentActivity student;
    ScoreActivity score;
    SubjectActivity subject;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        home = new HomeActivity();
        teacher = new TeacherActivity();
        student = new StudentActivity();
        score = new ScoreActivity();
        subject = new SubjectActivity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById((R.id.toolbar));
        nav = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer);
        bottomNavigationView = findViewById(R.id.bootambar);
        toolbar.setTitle("Student Management");
        setFragment(home);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.homeP) {
                    Toast.makeText(getApplicationContext(),"Trang chủ", Toast.LENGTH_SHORT).show();
                    setFragment(home);
                    bottomNavigationView.getMenu().findItem(R.id.homeP).setChecked(true);
                } else if (item.getItemId() == R.id.teacher) {
                    Toast.makeText(getApplicationContext(),"Giảng viên", Toast.LENGTH_SHORT).show();
                    setFragment(teacher);
                    bottomNavigationView.getMenu().findItem(R.id.teacher).setChecked(true);
                } else if (item.getItemId() == R.id.student) {
                    Toast.makeText(getApplicationContext(),"Sinh viên", Toast.LENGTH_SHORT).show();
                    setFragment(student);
                    bottomNavigationView.getMenu().findItem(R.id.student).setChecked(true);
                } else if (item.getItemId() == R.id.subject) {
                    Toast.makeText(getApplicationContext(),"Môn học", Toast.LENGTH_SHORT).show();
                    setFragment(subject);
                    bottomNavigationView.getMenu().findItem(R.id.subject).setChecked(true);
                } else if (item.getItemId() == R.id.score) {
                    Toast.makeText(getApplicationContext(),"Điểm số", Toast.LENGTH_SHORT).show();
                    setFragment(score);
                    bottomNavigationView.getMenu().findItem(R.id.score).setChecked(true);
                }else {
                    return false;
                }
                return true;
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.homeP) {
                    setFragment(home);
                    nav.setCheckedItem(R.id.homeP);
                } else if (item.getItemId() == R.id.teacher) {
                    setFragment(teacher);
                    nav.setCheckedItem(R.id.teacher);
                } else if (item.getItemId() == R.id.student) {
                    setFragment(student);
                    nav.setCheckedItem(R.id.student);
                } else if (item.getItemId() == R.id.subject) {
                    setFragment(subject);
                    nav.setCheckedItem(R.id.subject);
                } else if (item.getItemId() == R.id.score) {
                    setFragment(score);
                    nav.setCheckedItem(R.id.score);
                }else {
                    return false;
                }
                return true;
            }
        });
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}