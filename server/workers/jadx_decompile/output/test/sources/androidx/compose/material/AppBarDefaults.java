package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/AppBarDefaults;", "", "()V", "BottomAppBarElevation", "Landroidx/compose/ui/unit/Dp;", "getBottomAppBarElevation-D9Ej5fM", "()F", "F", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TopAppBarElevation", "getTopAppBarElevation-D9Ej5fM", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AppBarDefaults {
    public static final int $stable = 0;
    private static final PaddingValues ContentPadding;
    public static final AppBarDefaults INSTANCE = new AppBarDefaults();
    private static final float TopAppBarElevation = Dp.m5218constructorimpl(4);
    private static final float BottomAppBarElevation = Dp.m5218constructorimpl(8);

    private AppBarDefaults() {
    }

    static {
        float f;
        float f2;
        f = AppBarKt.AppBarHorizontalPadding;
        f2 = AppBarKt.AppBarHorizontalPadding;
        ContentPadding = PaddingKt.m481PaddingValuesa9UjIt4$default(f, 0.0f, f2, 0.0f, 10, null);
    }

    /* renamed from: getTopAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m964getTopAppBarElevationD9Ej5fM() {
        return TopAppBarElevation;
    }

    /* renamed from: getBottomAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m963getBottomAppBarElevationD9Ej5fM() {
        return BottomAppBarElevation;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }
}
