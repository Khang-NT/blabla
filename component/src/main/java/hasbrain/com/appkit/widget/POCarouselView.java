package hasbrain.com.appkit.widget;

import android.content.Context;
import android.view.View;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import hasbrain.com.appkit.PropertiesOfView;

/**
 * Created by blackcat on 11/07/2016.
 */
public class POCarouselView extends PropertiesOfView<CarouselView> {
    private static final String TAG = "POCarouselView";

    private int slideInterval;

    private boolean autoPlay;

    private PropertiesOfView[] pages;

    public POCarouselView() {
        this.slideInterval = 2000;
        this.autoPlay = true;
    }

    public int getSlideInterval() {
        return slideInterval;
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public PropertiesOfView[] getPages() {
        return pages;
    }

    @Override
    public CarouselView generateView(Context context) {
        return assignProperties(new CarouselView(context, null));
    }

    @Override
    public CarouselView assignProperties(final CarouselView input) {
        input.setSlideInterval(slideInterval);
        if (!autoPlay)
            input.stopCarousel();
        if (getPages() != null) {
            input.setPageCount(getPages().length);
            input.setViewListener(new ViewListener() {
                @Override
                public View setViewForPosition(int position) {
                    return getPages()[position].generateView(input.getContext());
                }
            });
        }
        return super.assignProperties(input);
    }
}
