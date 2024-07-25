package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* loaded from: classes5.dex */
public interface TintableCompoundButton {
    ColorStateList getSupportButtonTintList();

    PorterDuff.Mode getSupportButtonTintMode();

    void setSupportButtonTintList(ColorStateList colorStateList);

    void setSupportButtonTintMode(PorterDuff.Mode mode);
}
