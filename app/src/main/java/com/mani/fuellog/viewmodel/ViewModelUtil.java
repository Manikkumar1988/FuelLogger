package com.mani.fuellog.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelUtil {
    private ViewModelUtil() {}

    public static <T extends ViewModel> ViewModelProvider.Factory createFor(final T... model) {
        return new ViewModelProvider.Factory() {
            @Override
            public <T extends ViewModel> T create(Class<T> modelClass) {
                for(int i= 0; i<model.length; i++) {
                    if (modelClass.isAssignableFrom(model[i].getClass())) {
                        return (T) model[i];
                    }
                }
                throw new IllegalArgumentException("unexpected model class " + modelClass);
            }
        };
    }
}