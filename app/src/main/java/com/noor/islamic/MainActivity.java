package com.noor.islamic;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(Color.rgb(246, 249, 243));

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(24, 35, 24, 30);
        scroll.addView(content);

        TextView logo = new TextView(this);
        logo.setText("☪");
        logo.setTextSize(48);
        logo.setTextColor(Color.rgb(20, 105, 76));
        logo.setGravity(Gravity.CENTER);
        content.addView(logo);

        TextView title = new TextView(this);
        title.setText("Noor Islamic");
        title.setTextSize(30);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.rgb(20, 82, 60));
        title.setGravity(Gravity.CENTER);
        content.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Your daily companion for faith");
        subtitle.setTextSize(15);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 8, 0, 25);
        content.addView(subtitle);

        TextView greeting = new TextView(this);
        greeting.setText("السلام عليكم ورحمة الله وبركاته");
        greeting.setTextSize(23);
        greeting.setGravity(Gravity.CENTER);
        greeting.setTextColor(Color.rgb(20, 82, 60));
        greeting.setPadding(8, 24, 8, 24);
        greeting.setBackground(panel());
        content.addView(greeting);

        addSection("📖  Quran Majeed",
                "Read and reflect on the Holy Quran.");
        addSection("🤲  Daily Duas",
                "Explore duas for everyday life.");
        addSection("🕌  Prayer Times",
                "Prayer timings will be added in a future update.");
        addSection("📿  Daily Dhikr",
                "Remember Allah throughout your day.");

        TextView footer = new TextView(this);
        footer.setText("May Allah bless your day.");
        footer.setTextSize(14);
        footer.setGravity(Gravity.CENTER);
        footer.setTextColor(Color.GRAY);
        footer.setPadding(0, 25, 0, 0);
        content.addView(footer);

        setContentView(scroll);
    }

    private GradientDrawable panel() {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.WHITE);
        bg.setCornerRadius(24);
        bg.setStroke(1, Color.rgb(220, 230, 218));
        return bg;
    }

    private void addSection(String heading, String description) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(18, 17, 18, 17);
        card.setBackground(panel());

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(0, 14, 0, 0);

        TextView title = new TextView(this);
        title.setText(heading);
        title.setTextSize(19);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.rgb(20, 82, 60));
        card.addView(title);

        TextView desc = new TextView(this);
        desc.setText(description);
        desc.setTextSize(14);
        desc.setTextColor(Color.DKGRAY);
        desc.setPadding(0, 8, 0, 12);
        card.addView(desc);

        Button button = new Button(this);
        button.setText("Open section");
        button.setOnClickListener(v ->
                showMessage(heading, description));
        card.addView(button);

        content.addView(card, cardParams);
    }

    private void showMessage(String heading, String message) {
        new android.app.AlertDialog.Builder(this)
                .setTitle(heading)
                .setMessage(message +
                        "\n\nMore features and content will be added soon.")
                .setPositiveButton("OK", null)
                .show();
    }
}
