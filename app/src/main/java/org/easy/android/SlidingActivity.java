package org.easy.android;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.easy.ui.SlidingLayout;

/**
 * author：jyh
 * QQ：847145851
 * time：2019/4/10
 * https://github.com/ZengChong500373
 * describe：
 **/
public class SlidingActivity extends AppCompatActivity implements View.OnClickListener {
    private SlidingLayout slide_layout;

    private View menu;
    private TextView tvMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        initUi();
    }

    private void initUi() {
        slide_layout = findViewById(R.id.slide_layout);
        tvMode = findViewById(R.id.tvMode);
        slide_layout.setSliderFadeColor(0);
        menu = findViewById(R.id.menu);
        ViewGroup.LayoutParams params = menu.getLayoutParams();
        params.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.85f);
        menu.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btnLeft && !slide_layout.isOpen()) {
            return;
        }
        if (id == R.id.btnLeft) {
            slide_layout.openPane();
        } else if (id == R.id.btnDefault) {
            tvMode.setText("Default");
            slide_layout.setMode(SlidingLayout.Mode.DEFAULT);
            slide_layout.closePane();
        } else if (id == R.id.btnTranslation) {
            tvMode.setText("Translation");
            slide_layout.setMode(SlidingLayout.Mode.TRANSLATION);
            slide_layout.closePane();
        } else if (id == R.id.btnScaleMenu) {
            tvMode.setText("Scale Menu");
            slide_layout.setMode(SlidingLayout.Mode.SCALE_MENU);
            slide_layout.closePane();
        } else if (id == R.id.btnScalePanel) {
            tvMode.setText("Scale Panel");
            slide_layout.setMode(SlidingLayout.Mode.SCALE_PANEL);
            slide_layout.closePane();
        } else if (id == R.id.btnScaleBoth) {
            tvMode.setText("Scale Both");
            slide_layout.setMode(SlidingLayout.Mode.SCALE_BOTH);
            slide_layout.closePane();
        } else if (id == R.id.btnTranslationScale) {
            tvMode.setText("Translation Scale");
            slide_layout.setMode(SlidingLayout.Mode.TRANSLATION_SCALE);
            slide_layout.closePane();
        }


    }
}
