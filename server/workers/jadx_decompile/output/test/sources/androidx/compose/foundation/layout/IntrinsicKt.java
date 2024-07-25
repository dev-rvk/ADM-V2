package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Intrinsic.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"height", "Landroidx/compose/ui/Modifier;", "intrinsicSize", "Landroidx/compose/foundation/layout/IntrinsicSize;", "requiredHeight", "requiredWidth", "width", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IntrinsicKt {

    /* compiled from: Intrinsic.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IntrinsicSize.values().length];
            try {
                iArr[IntrinsicSize.Min.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[IntrinsicSize.Max.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Modifier width(Modifier $this$width, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter($this$width, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        switch (WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()]) {
            case 1:
                return $this$width.then(MinIntrinsicWidthModifier.INSTANCE);
            case 2:
                return $this$width.then(MaxIntrinsicWidthModifier.INSTANCE);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Modifier height(Modifier $this$height, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter($this$height, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        switch (WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()]) {
            case 1:
                return $this$height.then(MinIntrinsicHeightModifier.INSTANCE);
            case 2:
                return $this$height.then(MaxIntrinsicHeightModifier.INSTANCE);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Modifier requiredWidth(Modifier $this$requiredWidth, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter($this$requiredWidth, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        switch (WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()]) {
            case 1:
                return $this$requiredWidth.then(RequiredMinIntrinsicWidthModifier.INSTANCE);
            case 2:
                return $this$requiredWidth.then(RequiredMaxIntrinsicWidthModifier.INSTANCE);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Modifier requiredHeight(Modifier $this$requiredHeight, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter($this$requiredHeight, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        switch (WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()]) {
            case 1:
                return $this$requiredHeight.then(RequiredMinIntrinsicHeightModifier.INSTANCE);
            case 2:
                return $this$requiredHeight.then(RequiredMaxIntrinsicHeightModifier.INSTANCE);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
