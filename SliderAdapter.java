package com.elkanah.foodordermakert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter (Context context){
        this.context = context ;

    }
    public int[] slide_images={
            R.drawable.just_for_you,
            R.drawable.realtime_deal,
            R.drawable.ultra_low

    };
    public String[] slide_heading = {
            "Just for You",
            "Real-time Deal",
            "Ultra Low"
    };
    public String[] slide_description={

            "A food is something that provides nutrients. Nutrients are substances that provide: energy for activity,\n" +
                    "        growth, and all functions of the body such as breathing, digesting food, and keeping warm; materials for the growth and\n" +
                    "        repair of the body, and for keeping the immune system healthy.",
            "Every cell in the body depends on a continuous supply of calories and nutrients, whether obtained\n" +
                    "        through food, IV nutrients, or tube feedings. Eating and food, however, also have symbolic meanings associated with love,\n" +
                    "        sensuality, comfort, stress reduction, security, reward, and power.",
            "Foods are directly related to our body and mental and social health because each food or liquid\n" +
                    "        contains particular nutrition such as carbohydrates, protein, vitamins, minerals, fats, etc, which are very necessary for our\n" +
                    "        physical and mental growth."

    };



    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImage =(ImageView) view.findViewById(R.id.gettyImage);
        TextView slideHeadings =  (TextView) view.findViewById(R.id.Headings);
        TextView slideDesc = (TextView) view.findViewById(R.id.Description);


        slideImage.setImageResource(slide_images[position]);
        slideHeadings.setText(slide_heading[position]);
        slideDesc.setText(slide_description[position]);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}

