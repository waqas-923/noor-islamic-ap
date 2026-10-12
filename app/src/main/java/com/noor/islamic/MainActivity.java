package com.noor.islamic;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends Activity {

    private LinearLayout content;

    private final int green = Color.rgb(20, 105, 76);
    private final int darkGreen = Color.rgb(16, 72, 53);
    private final int background = Color.rgb(245, 249, 243);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(background);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(22, 28, 22, 28);

        scrollView.addView(content);

        TextView icon = new TextView(this);
        icon.setText("☪");
        icon.setTextSize(54);
        icon.setTextColor(green);
        icon.setGravity(Gravity.CENTER);
        content.addView(icon);

        TextView title = new TextView(this);
        title.setText("Noor Islamic");
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkGreen);
        title.setGravity(Gravity.CENTER);
        content.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Your Daily Islamic Companion");
        subtitle.setTextSize(15);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 8, 0, 24);
        content.addView(subtitle);

        TextView greeting = new TextView(this);
        greeting.setText("السلام عليكم ورحمة الله وبركاته");
        greeting.setTextSize(23);
        greeting.setTextColor(darkGreen);
        greeting.setGravity(Gravity.CENTER);
        greeting.setPadding(12, 24, 12, 24);
        greeting.setBackground(makeBackground(Color.WHITE));
        content.addView(greeting);

        addSection(
                "📖  Quran Majeed",
                "Holy Quran parhein aur uska paigham samjhein.",
                "Quran Majeed",
                "Quran ka mukammal Arabic text aur tarjuma jald shamil kiya jayega."
        );

        addSection(
                "🤲  Daily Duas",
                "Rozana zindagi ki masnoon duaein.",
                "Daily Duas",
                "Subah aur shaam ki duaein aur rozmarrah ki masnoon duaein jald shamil hongi."
        );

        addSection(
                "🕌  Prayer Times",
                "Apni namazon ki auqat check karein.",
                "Prayer Times",
                "Accurate namaz timings ke liye location aur prayer calculation settings add karni hongi."
        );

        addSection(
                "📿  Daily Dhikr",
                "Allah ka zikr apni rozana zindagi ka hissa banayein.",
                "Daily Dhikr",
                "Daily tasbeeh counter aur azkar ka feature aglay version mein shamil kiya ja sakta hai."
        );

        TextView footer = new TextView(this);
        footer.setText("May Allah bless you and your family.");
        footer.setTextSize(14);
        footer.setTextColor(Color.GRAY);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(8, 26, 8, 10);
        content.addView(footer);

        setContentView(scrollView);
    }

    private GradientDrawable makeBackground(int color) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setCornerRadius(24);
        drawable.setStroke(1, Color.rgb(220, 231, 221));
        return drawable;
    }

    private void addSection(
            String heading,
            String description,
            String dialogTitle,
            String dialogMessage) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(18, 18, 18, 16);
        card.setBackground(makeBackground(Color.WHITE));

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        cardParams.setMargins(0, 16, 0, 0);

        TextView headingView = new TextView(this);
        headingView.setText(heading);
        headingView.setTextSize(20);
        headingView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        headingView.setTextColor(darkGreen);
        card.addView(headingView);

        TextView descriptionView = new TextView(this);
        descriptionView.setText(description);
        descriptionView.setTextSize(14);
        descriptionView.setTextColor(Color.DKGRAY);
        descriptionView.setPadding(0, 10, 0, 12);
        card.addView(descriptionView);

        Button button = new Button(this);
        button.setText("Open Section");
        button.setTextColor(Color.WHITE);
        button.setBackground
