package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B°\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001e\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J.\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0017ø\u0001\u0000¢\u0006\u0002\u0010'J.\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0017ø\u0001\u0000¢\u0006\u0002\u0010'J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010*J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010*R\u0019\u0010\u0011\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0014\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0017\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0015\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0016\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0013\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+²\u0006\n\u0010,\u001a\u00020\u001cX\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020\u001cX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/DefaultTextFieldColors;", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "errorIndicatorColor", "disabledIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "backgroundColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "(JJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isError", "equals", "other", "", "hashCode", "", "indicatorColor", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "error", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release", "focused"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DefaultTextFieldColors implements TextFieldColors {
    private final long backgroundColor;
    private final long cursorColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorTrailingIconColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long leadingIconColor;
    private final long placeholderColor;
    private final long textColor;
    private final long trailingIconColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;

    public /* synthetic */ DefaultTextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21);
    }

    private DefaultTextFieldColors(long textColor, long disabledTextColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long errorIndicatorColor, long disabledIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long backgroundColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor) {
        this.textColor = textColor;
        this.disabledTextColor = disabledTextColor;
        this.cursorColor = cursorColor;
        this.errorCursorColor = errorCursorColor;
        this.focusedIndicatorColor = focusedIndicatorColor;
        this.unfocusedIndicatorColor = unfocusedIndicatorColor;
        this.errorIndicatorColor = errorIndicatorColor;
        this.disabledIndicatorColor = disabledIndicatorColor;
        this.leadingIconColor = leadingIconColor;
        this.disabledLeadingIconColor = disabledLeadingIconColor;
        this.errorLeadingIconColor = errorLeadingIconColor;
        this.trailingIconColor = trailingIconColor;
        this.disabledTrailingIconColor = disabledTrailingIconColor;
        this.errorTrailingIconColor = errorTrailingIconColor;
        this.backgroundColor = backgroundColor;
        this.focusedLabelColor = focusedLabelColor;
        this.unfocusedLabelColor = unfocusedLabelColor;
        this.disabledLabelColor = disabledLabelColor;
        this.errorLabelColor = errorLabelColor;
        this.placeholderColor = placeholderColor;
        this.disabledPlaceholderColor = disabledPlaceholderColor;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> leadingIconColor(boolean enabled, boolean isError, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(1016171324);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)699@32310L207:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1016171324, $changed, -1, "androidx.compose.material.DefaultTextFieldColors.leadingIconColor (TextFieldDefaults.kt:698)");
        }
        if (enabled) {
            j = isError ? this.errorLeadingIconColor : this.leadingIconColor;
        } else {
            j = this.disabledLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> trailingIconColor(boolean enabled, boolean isError, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(225259054);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)710@32643L210:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(225259054, $changed, -1, "androidx.compose.material.DefaultTextFieldColors.trailingIconColor (TextFieldDefaults.kt:709)");
        }
        if (enabled) {
            j = isError ? this.errorTrailingIconColor : this.trailingIconColor;
        } else {
            j = this.disabledTrailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> indicatorColor(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        State<Color> rememberUpdatedState;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(998675979);
        ComposerKt.sourceInformation($composer, "C(indicatorColor)P(!1,2)725@33070L25:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(998675979, $changed, -1, "androidx.compose.material.DefaultTextFieldColors.indicatorColor (TextFieldDefaults.kt:720)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledIndicatorColor;
        } else if (isError) {
            targetValue = this.errorIndicatorColor;
        } else {
            targetValue = indicatorColor$lambda$0(focused$delegate) ? this.focusedIndicatorColor : this.unfocusedIndicatorColor;
        }
        if (enabled) {
            $composer.startReplaceableGroup(-2054190397);
            ComposerKt.sourceInformation($composer, "734@33361L75");
            rememberUpdatedState = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(targetValue, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer, 48, 12);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(-2054190292);
            ComposerKt.sourceInformation($composer, "736@33466L33");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(targetValue), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean indicatorColor$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> backgroundColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1423938813);
        ComposerKt.sourceInformation($composer, "C(backgroundColor)742@33615L37:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1423938813, $changed, -1, "androidx.compose.material.DefaultTextFieldColors.backgroundColor (TextFieldDefaults.kt:741)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(this.backgroundColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> placeholderColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(264799724);
        ComposerKt.sourceInformation($composer, "C(placeholderColor)747@33759L81:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(264799724, $changed, -1, "androidx.compose.material.DefaultTextFieldColors.placeholderColor (TextFieldDefaults.kt:746)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.placeholderColor : this.disabledPlaceholderColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> labelColor(boolean enabled, boolean error, InteractionSource interactionSource, Composer $composer, int $changed) {
        long targetValue;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(727091888);
        ComposerKt.sourceInformation($composer, "C(labelColor)756@34051L25,764@34297L33:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(727091888, $changed, -1, "androidx.compose.material.DefaultTextFieldColors.labelColor (TextFieldDefaults.kt:751)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        if (!enabled) {
            targetValue = this.disabledLabelColor;
        } else if (error) {
            targetValue = this.errorLabelColor;
        } else {
            targetValue = labelColor$lambda$1(focused$delegate) ? this.focusedLabelColor : this.unfocusedLabelColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(targetValue), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean labelColor$lambda$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> textColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(9804418);
        ComposerKt.sourceInformation($composer, "C(textColor)769@34430L67:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(9804418, $changed, -1, "androidx.compose.material.DefaultTextFieldColors.textColor (TextFieldDefaults.kt:768)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.textColor : this.disabledTextColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> cursorColor(boolean isError, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1446422485);
        ComposerKt.sourceInformation($composer, "C(cursorColor)774@34599L68:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1446422485, $changed, -1, "androidx.compose.material.DefaultTextFieldColors.cursorColor (TextFieldDefaults.kt:773)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(isError ? this.errorCursorColor : this.cursorColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (Color.m2950equalsimpl0(this.textColor, ((DefaultTextFieldColors) other).textColor) && Color.m2950equalsimpl0(this.disabledTextColor, ((DefaultTextFieldColors) other).disabledTextColor) && Color.m2950equalsimpl0(this.cursorColor, ((DefaultTextFieldColors) other).cursorColor) && Color.m2950equalsimpl0(this.errorCursorColor, ((DefaultTextFieldColors) other).errorCursorColor) && Color.m2950equalsimpl0(this.focusedIndicatorColor, ((DefaultTextFieldColors) other).focusedIndicatorColor) && Color.m2950equalsimpl0(this.unfocusedIndicatorColor, ((DefaultTextFieldColors) other).unfocusedIndicatorColor) && Color.m2950equalsimpl0(this.errorIndicatorColor, ((DefaultTextFieldColors) other).errorIndicatorColor) && Color.m2950equalsimpl0(this.disabledIndicatorColor, ((DefaultTextFieldColors) other).disabledIndicatorColor) && Color.m2950equalsimpl0(this.leadingIconColor, ((DefaultTextFieldColors) other).leadingIconColor) && Color.m2950equalsimpl0(this.disabledLeadingIconColor, ((DefaultTextFieldColors) other).disabledLeadingIconColor) && Color.m2950equalsimpl0(this.errorLeadingIconColor, ((DefaultTextFieldColors) other).errorLeadingIconColor) && Color.m2950equalsimpl0(this.trailingIconColor, ((DefaultTextFieldColors) other).trailingIconColor) && Color.m2950equalsimpl0(this.disabledTrailingIconColor, ((DefaultTextFieldColors) other).disabledTrailingIconColor) && Color.m2950equalsimpl0(this.errorTrailingIconColor, ((DefaultTextFieldColors) other).errorTrailingIconColor) && Color.m2950equalsimpl0(this.backgroundColor, ((DefaultTextFieldColors) other).backgroundColor) && Color.m2950equalsimpl0(this.focusedLabelColor, ((DefaultTextFieldColors) other).focusedLabelColor) && Color.m2950equalsimpl0(this.unfocusedLabelColor, ((DefaultTextFieldColors) other).unfocusedLabelColor) && Color.m2950equalsimpl0(this.disabledLabelColor, ((DefaultTextFieldColors) other).disabledLabelColor) && Color.m2950equalsimpl0(this.errorLabelColor, ((DefaultTextFieldColors) other).errorLabelColor) && Color.m2950equalsimpl0(this.placeholderColor, ((DefaultTextFieldColors) other).placeholderColor) && Color.m2950equalsimpl0(this.disabledPlaceholderColor, ((DefaultTextFieldColors) other).disabledPlaceholderColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.textColor);
        return (((((((((((((((((((((((((((((((((((((((result * 31) + Color.m2956hashCodeimpl(this.disabledTextColor)) * 31) + Color.m2956hashCodeimpl(this.cursorColor)) * 31) + Color.m2956hashCodeimpl(this.errorCursorColor)) * 31) + Color.m2956hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.leadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.trailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.backgroundColor)) * 31) + Color.m2956hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m2956hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m2956hashCodeimpl(this.errorLabelColor)) * 31) + Color.m2956hashCodeimpl(this.placeholderColor)) * 31) + Color.m2956hashCodeimpl(this.disabledPlaceholderColor);
    }
}
