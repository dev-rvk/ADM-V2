package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: CheckboxTokens.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b(\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u0011\u0010$\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u0011\u0010&\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u001c\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u0011\u0010*\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0013R\u0011\u0010,\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0013R\u0011\u0010.\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0013R\u001c\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006R\u0011\u00102\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0013R\u0011\u00104\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0013R\u001c\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b7\u0010\u0006R\u0011\u00108\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0013R\u0011\u0010:\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0013R\u001c\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b=\u0010\u0006R\u0011\u0010>\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0013R\u001c\u0010@\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bA\u0010\u0006R\u0011\u0010B\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0013R\u0011\u0010D\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0013R\u001c\u0010F\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bG\u0010\u0006R\u0011\u0010H\u001a\u00020I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001c\u0010L\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bM\u0010\u0006R\u000e\u0010N\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010O\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0013R\u001c\u0010Q\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bR\u0010\u0006R\u0011\u0010S\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0013R\u001c\u0010U\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bV\u0010\u0006R\u0011\u0010W\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0013R\u001c\u0010Y\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bZ\u0010\u0006R\u0011\u0010[\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u0013R\u0011\u0010]\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0013R\u001c\u0010_\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b`\u0010\u0006R\u0011\u0010a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u0013R\u001c\u0010c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bd\u0010\u0006R\u0011\u0010e\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u0013R\u001c\u0010g\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bh\u0010\u0006R\u0011\u0010i\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u0013R\u001c\u0010k\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bl\u0010\u0006R\u0011\u0010m\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\u0013R\u001c\u0010o\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bp\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006q"}, d2 = {"Landroidx/compose/material3/tokens/CheckboxTokens;", "", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getContainerShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "ContainerWidth", "getContainerWidth-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "SelectedContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getSelectedContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "SelectedDisabledContainerColor", "getSelectedDisabledContainerColor", "SelectedDisabledContainerOpacity", "", "SelectedDisabledContainerOutlineWidth", "getSelectedDisabledContainerOutlineWidth-D9Ej5fM", "SelectedDisabledIconColor", "getSelectedDisabledIconColor", "SelectedErrorContainerColor", "getSelectedErrorContainerColor", "SelectedErrorFocusContainerColor", "getSelectedErrorFocusContainerColor", "SelectedErrorFocusIconColor", "getSelectedErrorFocusIconColor", "SelectedErrorFocusOutlineWidth", "getSelectedErrorFocusOutlineWidth-D9Ej5fM", "SelectedErrorHoverContainerColor", "getSelectedErrorHoverContainerColor", "SelectedErrorHoverIconColor", "getSelectedErrorHoverIconColor", "SelectedErrorHoverOutlineWidth", "getSelectedErrorHoverOutlineWidth-D9Ej5fM", "SelectedErrorIconColor", "getSelectedErrorIconColor", "SelectedErrorPressedContainerColor", "getSelectedErrorPressedContainerColor", "SelectedErrorPressedIconColor", "getSelectedErrorPressedIconColor", "SelectedErrorPressedOutlineWidth", "getSelectedErrorPressedOutlineWidth-D9Ej5fM", "SelectedFocusContainerColor", "getSelectedFocusContainerColor", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedFocusOutlineWidth", "getSelectedFocusOutlineWidth-D9Ej5fM", "SelectedHoverContainerColor", "getSelectedHoverContainerColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedHoverOutlineWidth", "getSelectedHoverOutlineWidth-D9Ej5fM", "SelectedIconColor", "getSelectedIconColor", "SelectedOutlineWidth", "getSelectedOutlineWidth-D9Ej5fM", "SelectedPressedContainerColor", "getSelectedPressedContainerColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "SelectedPressedOutlineWidth", "getSelectedPressedOutlineWidth-D9Ej5fM", "StateLayerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getStateLayerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedDisabledContainerOpacity", "UnselectedDisabledOutlineColor", "getUnselectedDisabledOutlineColor", "UnselectedDisabledOutlineWidth", "getUnselectedDisabledOutlineWidth-D9Ej5fM", "UnselectedErrorFocusOutlineColor", "getUnselectedErrorFocusOutlineColor", "UnselectedErrorFocusOutlineWidth", "getUnselectedErrorFocusOutlineWidth-D9Ej5fM", "UnselectedErrorHoverOutlineColor", "getUnselectedErrorHoverOutlineColor", "UnselectedErrorHoverOutlineWidth", "getUnselectedErrorHoverOutlineWidth-D9Ej5fM", "UnselectedErrorOutlineColor", "getUnselectedErrorOutlineColor", "UnselectedErrorPressedOutlineColor", "getUnselectedErrorPressedOutlineColor", "UnselectedErrorPressedOutlineWidth", "getUnselectedErrorPressedOutlineWidth-D9Ej5fM", "UnselectedFocusOutlineColor", "getUnselectedFocusOutlineColor", "UnselectedFocusOutlineWidth", "getUnselectedFocusOutlineWidth-D9Ej5fM", "UnselectedHoverOutlineColor", "getUnselectedHoverOutlineColor", "UnselectedHoverOutlineWidth", "getUnselectedHoverOutlineWidth-D9Ej5fM", "UnselectedOutlineColor", "getUnselectedOutlineColor", "UnselectedOutlineWidth", "getUnselectedOutlineWidth-D9Ej5fM", "UnselectedPressedOutlineColor", "getUnselectedPressedOutlineColor", "UnselectedPressedOutlineWidth", "getUnselectedPressedOutlineWidth-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CheckboxTokens {
    public static final float SelectedDisabledContainerOpacity = 0.38f;
    public static final float UnselectedDisabledContainerOpacity = 0.38f;
    public static final CheckboxTokens INSTANCE = new CheckboxTokens();
    private static final float ContainerHeight = Dp.m5218constructorimpl((float) 18.0d);
    private static final RoundedCornerShape ContainerShape = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(Dp.m5218constructorimpl((float) 2.0d));
    private static final float ContainerWidth = Dp.m5218constructorimpl((float) 18.0d);
    private static final float IconSize = Dp.m5218constructorimpl((float) 18.0d);
    private static final ColorSchemeKeyTokens SelectedContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedDisabledContainerColor = ColorSchemeKeyTokens.OnSurface;
    private static final float SelectedDisabledContainerOutlineWidth = Dp.m5218constructorimpl((float) 0.0d);
    private static final ColorSchemeKeyTokens SelectedDisabledIconColor = ColorSchemeKeyTokens.Surface;
    private static final ColorSchemeKeyTokens SelectedErrorContainerColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens SelectedErrorFocusContainerColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens SelectedErrorFocusIconColor = ColorSchemeKeyTokens.OnError;
    private static final float SelectedErrorFocusOutlineWidth = Dp.m5218constructorimpl((float) 0.0d);
    private static final ColorSchemeKeyTokens SelectedErrorHoverContainerColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens SelectedErrorHoverIconColor = ColorSchemeKeyTokens.OnError;
    private static final float SelectedErrorHoverOutlineWidth = Dp.m5218constructorimpl((float) 0.0d);
    private static final ColorSchemeKeyTokens SelectedErrorIconColor = ColorSchemeKeyTokens.OnError;
    private static final ColorSchemeKeyTokens SelectedErrorPressedContainerColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens SelectedErrorPressedIconColor = ColorSchemeKeyTokens.OnError;
    private static final float SelectedErrorPressedOutlineWidth = Dp.m5218constructorimpl((float) 0.0d);
    private static final ColorSchemeKeyTokens SelectedFocusContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedFocusIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final float SelectedFocusOutlineWidth = Dp.m5218constructorimpl((float) 0.0d);
    private static final ColorSchemeKeyTokens SelectedHoverContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedHoverIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final float SelectedHoverOutlineWidth = Dp.m5218constructorimpl((float) 0.0d);
    private static final ColorSchemeKeyTokens SelectedIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final float SelectedOutlineWidth = Dp.m5218constructorimpl((float) 0.0d);
    private static final ColorSchemeKeyTokens SelectedPressedContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedPressedIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final float SelectedPressedOutlineWidth = Dp.m5218constructorimpl((float) 0.0d);
    private static final ShapeKeyTokens StateLayerShape = ShapeKeyTokens.CornerFull;
    private static final float StateLayerSize = Dp.m5218constructorimpl((float) 40.0d);
    private static final ColorSchemeKeyTokens UnselectedDisabledOutlineColor = ColorSchemeKeyTokens.OnSurface;
    private static final float UnselectedDisabledOutlineWidth = Dp.m5218constructorimpl((float) 2.0d);
    private static final ColorSchemeKeyTokens UnselectedErrorFocusOutlineColor = ColorSchemeKeyTokens.Error;
    private static final float UnselectedErrorFocusOutlineWidth = Dp.m5218constructorimpl((float) 2.0d);
    private static final ColorSchemeKeyTokens UnselectedErrorHoverOutlineColor = ColorSchemeKeyTokens.Error;
    private static final float UnselectedErrorHoverOutlineWidth = Dp.m5218constructorimpl((float) 2.0d);
    private static final ColorSchemeKeyTokens UnselectedErrorOutlineColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens UnselectedErrorPressedOutlineColor = ColorSchemeKeyTokens.Error;
    private static final float UnselectedErrorPressedOutlineWidth = Dp.m5218constructorimpl((float) 2.0d);
    private static final ColorSchemeKeyTokens UnselectedFocusOutlineColor = ColorSchemeKeyTokens.OnSurface;
    private static final float UnselectedFocusOutlineWidth = Dp.m5218constructorimpl((float) 2.0d);
    private static final ColorSchemeKeyTokens UnselectedHoverOutlineColor = ColorSchemeKeyTokens.OnSurface;
    private static final float UnselectedHoverOutlineWidth = Dp.m5218constructorimpl((float) 2.0d);
    private static final ColorSchemeKeyTokens UnselectedOutlineColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    private static final float UnselectedOutlineWidth = Dp.m5218constructorimpl((float) 2.0d);
    private static final ColorSchemeKeyTokens UnselectedPressedOutlineColor = ColorSchemeKeyTokens.OnSurface;
    private static final float UnselectedPressedOutlineWidth = Dp.m5218constructorimpl((float) 2.0d);

    private CheckboxTokens() {
    }

    /* renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2016getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final RoundedCornerShape getContainerShape() {
        return ContainerShape;
    }

    /* renamed from: getContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2017getContainerWidthD9Ej5fM() {
        return ContainerWidth;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2018getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ColorSchemeKeyTokens getSelectedContainerColor() {
        return SelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedDisabledContainerColor() {
        return SelectedDisabledContainerColor;
    }

    /* renamed from: getSelectedDisabledContainerOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2019getSelectedDisabledContainerOutlineWidthD9Ej5fM() {
        return SelectedDisabledContainerOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedDisabledIconColor() {
        return SelectedDisabledIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorContainerColor() {
        return SelectedErrorContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorFocusContainerColor() {
        return SelectedErrorFocusContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorFocusIconColor() {
        return SelectedErrorFocusIconColor;
    }

    /* renamed from: getSelectedErrorFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2020getSelectedErrorFocusOutlineWidthD9Ej5fM() {
        return SelectedErrorFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedErrorHoverContainerColor() {
        return SelectedErrorHoverContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorHoverIconColor() {
        return SelectedErrorHoverIconColor;
    }

    /* renamed from: getSelectedErrorHoverOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2021getSelectedErrorHoverOutlineWidthD9Ej5fM() {
        return SelectedErrorHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedErrorIconColor() {
        return SelectedErrorIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorPressedContainerColor() {
        return SelectedErrorPressedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorPressedIconColor() {
        return SelectedErrorPressedIconColor;
    }

    /* renamed from: getSelectedErrorPressedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2022getSelectedErrorPressedOutlineWidthD9Ej5fM() {
        return SelectedErrorPressedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedFocusContainerColor() {
        return SelectedFocusContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return SelectedFocusIconColor;
    }

    /* renamed from: getSelectedFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2023getSelectedFocusOutlineWidthD9Ej5fM() {
        return SelectedFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedHoverContainerColor() {
        return SelectedHoverContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return SelectedHoverIconColor;
    }

    /* renamed from: getSelectedHoverOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2024getSelectedHoverOutlineWidthD9Ej5fM() {
        return SelectedHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return SelectedIconColor;
    }

    /* renamed from: getSelectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2025getSelectedOutlineWidthD9Ej5fM() {
        return SelectedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedPressedContainerColor() {
        return SelectedPressedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return SelectedPressedIconColor;
    }

    /* renamed from: getSelectedPressedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2026getSelectedPressedOutlineWidthD9Ej5fM() {
        return SelectedPressedOutlineWidth;
    }

    public final ShapeKeyTokens getStateLayerShape() {
        return StateLayerShape;
    }

    /* renamed from: getStateLayerSize-D9Ej5fM, reason: not valid java name */
    public final float m2027getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }

    public final ColorSchemeKeyTokens getUnselectedDisabledOutlineColor() {
        return UnselectedDisabledOutlineColor;
    }

    /* renamed from: getUnselectedDisabledOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2028getUnselectedDisabledOutlineWidthD9Ej5fM() {
        return UnselectedDisabledOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorFocusOutlineColor() {
        return UnselectedErrorFocusOutlineColor;
    }

    /* renamed from: getUnselectedErrorFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2029getUnselectedErrorFocusOutlineWidthD9Ej5fM() {
        return UnselectedErrorFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorHoverOutlineColor() {
        return UnselectedErrorHoverOutlineColor;
    }

    /* renamed from: getUnselectedErrorHoverOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2030getUnselectedErrorHoverOutlineWidthD9Ej5fM() {
        return UnselectedErrorHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorOutlineColor() {
        return UnselectedErrorOutlineColor;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorPressedOutlineColor() {
        return UnselectedErrorPressedOutlineColor;
    }

    /* renamed from: getUnselectedErrorPressedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2031getUnselectedErrorPressedOutlineWidthD9Ej5fM() {
        return UnselectedErrorPressedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusOutlineColor() {
        return UnselectedFocusOutlineColor;
    }

    /* renamed from: getUnselectedFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2032getUnselectedFocusOutlineWidthD9Ej5fM() {
        return UnselectedFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedHoverOutlineColor() {
        return UnselectedHoverOutlineColor;
    }

    /* renamed from: getUnselectedHoverOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2033getUnselectedHoverOutlineWidthD9Ej5fM() {
        return UnselectedHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedOutlineColor() {
        return UnselectedOutlineColor;
    }

    /* renamed from: getUnselectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2034getUnselectedOutlineWidthD9Ej5fM() {
        return UnselectedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedOutlineColor() {
        return UnselectedPressedOutlineColor;
    }

    /* renamed from: getUnselectedPressedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2035getUnselectedPressedOutlineWidthD9Ej5fM() {
        return UnselectedPressedOutlineWidth;
    }
}
