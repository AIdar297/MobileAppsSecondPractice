package com.example.secondpractice;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button lastimg;
    private Button nextimg;
    private ImageView img;
    private TextView textView;
    private int[] pictures = {
            R.drawable.fox,
            R.drawable.leopard,
            R.drawable.lion,
            R.drawable.lynx,
            R.drawable.tiger};

    private TextView imageName;
    private Button randomimg;

    private String[] names = {
            "Лиса",
            "Леопард",
            "Лев",
            "Рысь",
            "Тигр"};

    private int index = 0;
    private int count = pictures.length-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Input();
    }

    private void Input()
    {
        lastimg = (Button) findViewById(R.id.lastimg);
        lastimg.setOnClickListener(this);

        nextimg = (Button) findViewById(R.id.nextimg);
        nextimg.setOnClickListener(this);

        img = (ImageView) findViewById(R.id.img);
        textView = (TextView) findViewById(R.id.textView);

        img.setImageResource(pictures[index]);
        textView.setText(Integer.toString(index + 1) + "/" + pictures.length);

        imageName = findViewById(R.id.imageName);
        randomimg = findViewById(R.id.randomimg);

        randomimg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.lastimg) {
            // Предыдущее изображение
            if (index == 0)
                index = count;
            else
                index = index - 1;
        }
        else if (view.getId() == R.id.nextimg) {
            // Следующее изображение
            if (index == count)
                index = 0;
            else
                index = index + 1;
        }
        else if (view.getId() == R.id.randomimg) {
            int newIndex;
            do
            {
                newIndex = (int) (Math.random() * pictures.length);
            }
            while (pictures.length > 1 && newIndex == index);
            index = newIndex;
        }

        updateImage();
    }

    private void updateImage() {
        img.setImageResource(pictures[index]);
        textView.setText((index + 1) + "/" + pictures.length);

        imageName.setText(names[index]);
    }
}
