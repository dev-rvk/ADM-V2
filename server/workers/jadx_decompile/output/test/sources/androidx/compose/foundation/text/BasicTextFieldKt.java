package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicTextField.kt */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010&\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010)\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020%X\u008a\u008e\u0002"}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "textFieldValueState", "lastTextValue"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BasicTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x052e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x051d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final java.lang.String r40, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r41, androidx.compose.ui.Modifier r42, boolean r43, boolean r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.text.KeyboardOptions r46, androidx.compose.foundation.text.KeyboardActions r47, boolean r48, int r49, int r50, androidx.compose.ui.text.input.VisualTransformation r51, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r52, androidx.compose.foundation.interaction.MutableInteractionSource r53, androidx.compose.ui.graphics.Brush r54, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.runtime.Composer r56, final int r57, final int r58, final int r59) {
        /*
            Method dump skipped, instructions count: 1550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$2(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BasicTextField$lambda$6(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x04b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final androidx.compose.ui.text.input.TextFieldValue r39, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r40, androidx.compose.ui.Modifier r41, boolean r42, boolean r43, androidx.compose.ui.text.TextStyle r44, androidx.compose.foundation.text.KeyboardOptions r45, androidx.compose.foundation.text.KeyboardActions r46, boolean r47, int r48, int r49, androidx.compose.ui.text.input.VisualTransformation r50, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.ui.graphics.Brush r53, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instructions count: 1267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int maxLines2;
        VisualTransformation visualTransformation2;
        Function1 onTextLayout2;
        MutableInteractionSource interactionSource2;
        Brush cursorBrush2;
        Function3 decorationBox2;
        Composer $composer2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-454732590);
        ComposerKt.sourceInformation($composer3, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)326@18012L39,331@18252L579:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer3.changed(textStyle) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(visualTransformation) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(onTextLayout) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(cursorBrush) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty1 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty1 |= $composer3.changedInstance(decorationBox) ? 16384 : 8192;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            visualTransformation2 = visualTransformation;
            onTextLayout2 = onTextLayout;
            interactionSource2 = interactionSource;
            cursorBrush2 = cursorBrush;
            decorationBox2 = decorationBox;
            $composer2 = $composer3;
        } else {
            modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
            enabled2 = i3 != 0 ? true : enabled;
            readOnly2 = i4 != 0 ? false : readOnly;
            textStyle2 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
            keyboardOptions2 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
            keyboardActions2 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
            singleLine2 = i8 != 0 ? false : singleLine;
            maxLines2 = i9 != 0 ? Integer.MAX_VALUE : maxLines;
            visualTransformation2 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
            onTextLayout2 = i11 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$10
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            } : onTextLayout;
            if (i12 != 0) {
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer3.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer3.endReplaceableGroup();
                interactionSource2 = (MutableInteractionSource) value$iv$iv;
            } else {
                interactionSource2 = interactionSource;
            }
            cursorBrush2 = i13 != 0 ? new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null) : cursorBrush;
            decorationBox2 = i14 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m756getLambda3$foundation_release() : decorationBox;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-454732590, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:313)");
            }
            $composer2 = $composer3;
            BasicTextField(value, (Function1<? super String, Unit>) onValueChange, modifier2, enabled2, readOnly2, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, 1, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, interactionSource2, cursorBrush2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) decorationBox2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 3) & 112) | 6 | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (($dirty1 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final boolean z = enabled2;
        final boolean z2 = readOnly2;
        final TextStyle textStyle3 = textStyle2;
        final KeyboardOptions keyboardOptions3 = keyboardOptions2;
        final KeyboardActions keyboardActions3 = keyboardActions2;
        final boolean z3 = singleLine2;
        final int i15 = maxLines2;
        final VisualTransformation visualTransformation3 = visualTransformation2;
        final Function1 function1 = onTextLayout2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final Brush brush = cursorBrush2;
        final Function3 function3 = decorationBox2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$12
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i16) {
                BasicTextFieldKt.BasicTextField(value, onValueChange, modifier3, z, z2, textStyle3, keyboardOptions3, keyboardActions3, z3, i15, visualTransformation3, function1, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int maxLines2;
        VisualTransformation visualTransformation2;
        Function1 onTextLayout2;
        MutableInteractionSource interactionSource2;
        Brush cursorBrush2;
        Function3 decorationBox2;
        Composer $composer2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation($composer3, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)366@19537L39,371@19777L579:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer3.changed(textStyle) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(visualTransformation) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(onTextLayout) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(cursorBrush) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty1 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty1 |= $composer3.changedInstance(decorationBox) ? 16384 : 8192;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            visualTransformation2 = visualTransformation;
            onTextLayout2 = onTextLayout;
            interactionSource2 = interactionSource;
            cursorBrush2 = cursorBrush;
            decorationBox2 = decorationBox;
            $composer2 = $composer3;
        } else {
            modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
            enabled2 = i3 != 0 ? true : enabled;
            readOnly2 = i4 != 0 ? false : readOnly;
            textStyle2 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
            keyboardOptions2 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
            keyboardActions2 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
            singleLine2 = i8 != 0 ? false : singleLine;
            maxLines2 = i9 != 0 ? Integer.MAX_VALUE : maxLines;
            visualTransformation2 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
            onTextLayout2 = i11 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$13
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            } : onTextLayout;
            if (i12 != 0) {
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer3.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer3.endReplaceableGroup();
                interactionSource2 = (MutableInteractionSource) value$iv$iv;
            } else {
                interactionSource2 = interactionSource;
            }
            cursorBrush2 = i13 != 0 ? new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null) : cursorBrush;
            decorationBox2 = i14 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m757getLambda4$foundation_release() : decorationBox;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-560482651, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:353)");
            }
            $composer2 = $composer3;
            BasicTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier2, enabled2, readOnly2, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, 1, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, interactionSource2, cursorBrush2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) decorationBox2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 3) & 112) | 6 | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (($dirty1 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final boolean z = enabled2;
        final boolean z2 = readOnly2;
        final TextStyle textStyle3 = textStyle2;
        final KeyboardOptions keyboardOptions3 = keyboardOptions2;
        final KeyboardActions keyboardActions3 = keyboardActions2;
        final boolean z3 = singleLine2;
        final int i15 = maxLines2;
        final VisualTransformation visualTransformation3 = visualTransformation2;
        final Function1 function1 = onTextLayout2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final Brush brush = cursorBrush2;
        final Function3 function3 = decorationBox2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$15
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i16) {
                BasicTextFieldKt.BasicTextField(TextFieldValue.this, onValueChange, modifier3, z, z2, textStyle3, keyboardOptions3, keyboardActions3, z3, i15, visualTransformation3, function1, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }
}
