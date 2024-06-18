package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010.\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001a\u0083\u0002\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010#\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010<\u001a\u00020=H\u0001ø\u0001\u0000¢\u0006\u0002\u0010>\u001am\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001am\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a)\u0010X\u001a\u00020\r*\u00020\r2\u0006\u0010Y\u001a\u0002092\u0006\u0010<\u001a\u00020=H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bZ\u0010[\u001a\u009a\u0001\u0010\\\u001a\u00020\u0007*\u00020]2\u0006\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020%2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010c\u001a\u0004\u0018\u00010a2\b\u0010d\u001a\u0004\u0018\u00010a2\u0006\u0010e\u001a\u00020a2\b\u0010f\u001a\u0004\u0018\u00010a2\b\u0010g\u001a\u0004\u0018\u00010a2\u0006\u0010h\u001a\u00020a2\b\u0010i\u001a\u0004\u0018\u00010a2\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010J\u001a\u0002072\u0006\u0010j\u001a\u00020k2\u0006\u0010<\u001a\u00020=H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006l"}, d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "prefixPlaceableHeight", "suffixPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "supportingPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-DHJA7U0", "(IIIIIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-DHJA7U0", "(IIIIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m5218constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m5218constructorimpl(8);

    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        int i3;
        int maxLines2;
        boolean readOnly2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int minLines2;
        int $dirty;
        int $dirty1;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        Shape shape3;
        int $dirty2;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Function2 prefix;
        Function2 label;
        Function2 suffix;
        Function2 supportingText;
        boolean isError2;
        int maxLines3;
        int $dirty3;
        int $dirty12;
        TextFieldColors colors2;
        TextStyle textStyle3;
        Object value$iv$iv;
        TextFieldColors colors3;
        TextStyle textStyle4;
        Composer $composer2;
        Shape shape4;
        MutableInteractionSource interactionSource5;
        int maxLines4;
        boolean isError3;
        Function2 supportingText2;
        Function2 supportingText3;
        Function2 suffix2;
        Function2 prefix2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        Function2 placeholder2;
        boolean enabled4;
        Modifier modifier4;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1922450045);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)145@8187L7,160@8939L39,161@9025L5,162@9088L8,170@9450L15,170@9384L2436:OutlinedTextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(textStyle)) {
                i7 = 131072;
                $dirty4 |= i7;
            }
            i7 = 65536;
            $dirty4 |= i7;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        int i12 = i & 128;
        if (i12 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        int i13 = i & 256;
        if (i13 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i14 = i & 512;
        if (i14 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        }
        int i15 = i & 1024;
        if (i15 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(function25) ? 4 : 2;
        }
        int i16 = i & 2048;
        if (i16 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty13 |= $composer3.changedInstance(function26) ? 32 : 16;
        }
        int i17 = i & 4096;
        if (i17 != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(function27) ? 256 : 128;
        }
        int i18 = i & 8192;
        if (i18 != 0) {
            $dirty13 |= 3072;
            i2 = i18;
        } else {
            i2 = i18;
            if (($changed1 & 7168) == 0) {
                $dirty13 |= $composer3.changed(isError) ? 2048 : 1024;
            }
        }
        int i19 = i & 16384;
        if (i19 != 0) {
            $dirty13 |= 24576;
            i3 = i19;
        } else if (($changed1 & 57344) == 0) {
            i3 = i19;
            $dirty13 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        } else {
            i3 = i19;
        }
        int i20 = i & 32768;
        if (i20 != 0) {
            $dirty13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty13 |= $composer3.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty13 |= $composer3.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i22 = i & 131072;
        if (i22 != 0) {
            $dirty13 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0) {
                maxLines2 = maxLines;
                if ($composer3.changed(maxLines2)) {
                    i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty13 |= i6;
                }
            } else {
                maxLines2 = maxLines;
            }
            i6 = 33554432;
            $dirty13 |= i6;
        } else {
            maxLines2 = maxLines;
        }
        int i23 = i & 524288;
        if (i23 != 0) {
            $dirty13 |= 805306368;
        } else if (($changed1 & 1879048192) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        }
        int i24 = i & 1048576;
        if (i24 != 0) {
            $dirty22 |= 6;
        } else if (($changed2 & 14) == 0) {
            $dirty22 |= $composer3.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 112) == 0) {
            if ((i & 2097152) == 0 && $composer3.changed(shape)) {
                i5 = 32;
                $dirty22 |= i5;
            }
            i5 = 16;
            $dirty22 |= i5;
        }
        if (($changed2 & 896) == 0) {
            if ((i & 4194304) == 0 && $composer3.changed(colors)) {
                i4 = 256;
                $dirty22 |= i4;
            }
            i4 = 128;
            $dirty22 |= i4;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && ($dirty22 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled4 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            placeholder2 = function2;
            leadingIcon2 = function22;
            trailingIcon2 = function23;
            prefix2 = function24;
            suffix2 = function25;
            supportingText3 = function26;
            supportingText2 = function27;
            isError3 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            minLines2 = minLines;
            interactionSource5 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            maxLines4 = maxLines2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i8 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled5 = i9 != 0 ? true : enabled;
                readOnly2 = i10 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) consume;
                    $dirty4 &= -458753;
                } else {
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    textStyle2 = textStyle;
                }
                Function2 label2 = i11 != 0 ? null : function2;
                Function2 placeholder3 = i12 != 0 ? null : function22;
                Function2 leadingIcon3 = i13 != 0 ? null : function23;
                Function2 trailingIcon3 = i14 != 0 ? null : function24;
                Function2 prefix3 = i15 != 0 ? null : function25;
                Function2 suffix3 = i16 != 0 ? null : function26;
                Function2 supportingText4 = i17 != 0 ? null : function27;
                boolean isError4 = i2 != 0 ? false : isError;
                visualTransformation2 = i3 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                keyboardOptions2 = i20 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                keyboardActions2 = i21 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i22 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty13 &= -234881025;
                }
                minLines2 = i23 != 0 ? 1 : minLines;
                if (i24 != 0) {
                    $dirty = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    $dirty1 = $dirty13;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty4;
                    $dirty1 = $dirty13;
                    interactionSource2 = interactionSource;
                }
                if ((2097152 & i) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty22 &= -113;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    shape3 = shape2;
                    $dirty2 = $dirty22 & (-897);
                    placeholder = placeholder3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    prefix = prefix3;
                    label = label2;
                    suffix = suffix3;
                    supportingText = supportingText4;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.m1637colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    textStyle3 = textStyle2;
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    shape3 = shape2;
                    $dirty2 = $dirty22;
                    placeholder = placeholder3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    prefix = prefix3;
                    label = label2;
                    suffix = suffix3;
                    supportingText = supportingText4;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = colors;
                    textStyle3 = textStyle2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 262144) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty22 &= -113;
                }
                if ((i & 4194304) != 0) {
                    $dirty22 &= -897;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                label = function2;
                placeholder = function22;
                leadingIcon = function23;
                trailingIcon = function24;
                prefix = function25;
                suffix = function26;
                supportingText = function27;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                minLines2 = minLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty12 = $dirty13;
                $dirty2 = $dirty22;
                maxLines3 = maxLines2;
                textStyle3 = textStyle;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1922450045, $dirty3, $dirty12, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:139)");
            }
            $composer3.startReplaceableGroup(1663535868);
            ComposerKt.sourceInformation($composer3, "*166@9248L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4747getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor$material3_release(enabled3, isError2, interactionSource4, $composer3, (($dirty3 >> 9) & 14) | (($dirty12 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m2959unboximpl();
            $composer3.endReplaceableGroup();
            final TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null));
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer3, ($dirty2 >> 6) & 14))};
            final Function2 function28 = label;
            final Modifier modifier6 = modifier3;
            final TextFieldColors textFieldColors = colors2;
            final boolean z = isError2;
            final int i25 = $dirty12;
            final int i26 = $dirty2;
            final boolean z2 = enabled3;
            final boolean z3 = readOnly2;
            final int $dirty5 = $dirty3;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActions keyboardActions3 = keyboardActions2;
            colors3 = colors2;
            final boolean z4 = singleLine2;
            textStyle4 = textStyle3;
            final int i27 = maxLines3;
            final int i28 = minLines2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Function2 function29 = placeholder;
            final Function2 function210 = leadingIcon;
            final Function2 function211 = trailingIcon;
            final Function2 function212 = prefix;
            final Function2 function213 = suffix;
            final Function2 function214 = supportingText;
            final Shape shape5 = shape3;
            Function2<Composer, Integer, Unit> function215 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2
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

                public final void invoke(Composer $composer4, int $changed3) {
                    Modifier modifier7;
                    ComposerKt.sourceInformation($composer4, "C190@10308L20,171@9477L2337:OutlinedTextField.kt#uh7d8r");
                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1886965181, $changed3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:170)");
                        }
                        if (function28 != null) {
                            modifier7 = PaddingKt.m488paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier6, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                        } else {
                            modifier7 = modifier6;
                        }
                        Modifier m515defaultMinSizeVpY3zN4 = SizeKt.m515defaultMinSizeVpY3zN4(modifier7, OutlinedTextFieldDefaults.INSTANCE.m1641getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m1640getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(textFieldColors.cursorColor$material3_release(z, $composer4, ((i25 >> 9) & 14) | ((i26 >> 3) & 112)).getValue().m2959unboximpl(), null);
                        final String str = value;
                        final boolean z5 = z2;
                        final boolean z6 = z4;
                        final VisualTransformation visualTransformation4 = visualTransformation3;
                        final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        final boolean z7 = z;
                        final Function2<Composer, Integer, Unit> function216 = function28;
                        final Function2<Composer, Integer, Unit> function217 = function29;
                        final Function2<Composer, Integer, Unit> function218 = function210;
                        final Function2<Composer, Integer, Unit> function219 = function211;
                        final Function2<Composer, Integer, Unit> function220 = function212;
                        final Function2<Composer, Integer, Unit> function221 = function213;
                        final Function2<Composer, Integer, Unit> function222 = function214;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final int i29 = $dirty5;
                        final int i30 = i25;
                        final int i31 = i26;
                        final Shape shape6 = shape5;
                        BasicTextFieldKt.BasicTextField(value, onValueChange, m515defaultMinSizeVpY3zN4, z2, z3, mergedTextStyle, keyboardOptions3, keyboardActions3, z4, i27, i28, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, solidColor, ComposableLambdaKt.composableLambda($composer4, 1474611661, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function223, Composer composer, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function223, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer5, int $changed4) {
                                Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                ComposerKt.sourceInformation($composer5, "C199@10744L1046:OutlinedTextField.kt#uh7d8r");
                                int $dirty6 = $changed4;
                                if (($changed4 & 14) == 0) {
                                    $dirty6 |= $composer5.changedInstance(innerTextField) ? 4 : 2;
                                }
                                int $dirty7 = $dirty6;
                                if (($dirty7 & 91) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1474611661, $dirty7, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:198)");
                                    }
                                    OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                    String str2 = str;
                                    boolean z8 = z5;
                                    boolean z9 = z6;
                                    VisualTransformation visualTransformation5 = visualTransformation4;
                                    MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                    boolean z10 = z7;
                                    Function2<Composer, Integer, Unit> function223 = function216;
                                    Function2<Composer, Integer, Unit> function224 = function217;
                                    Function2<Composer, Integer, Unit> function225 = function218;
                                    Function2<Composer, Integer, Unit> function226 = function219;
                                    Function2<Composer, Integer, Unit> function227 = function220;
                                    Function2<Composer, Integer, Unit> function228 = function221;
                                    Function2<Composer, Integer, Unit> function229 = function222;
                                    TextFieldColors textFieldColors3 = textFieldColors2;
                                    final boolean z11 = z5;
                                    final boolean z12 = z7;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                    final Shape shape7 = shape6;
                                    final int i32 = i29;
                                    final int i33 = i30;
                                    final int i34 = i31;
                                    outlinedTextFieldDefaults.DecorationBox(str2, innerTextField, z8, z9, visualTransformation5, mutableInteractionSource3, z10, function223, function224, function225, function226, function227, function228, function229, textFieldColors3, null, ComposableLambdaKt.composableLambda($composer5, 2108828640, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer6, int $changed5) {
                                            ComposerKt.sourceInformation($composer6, "C216@11520L230:OutlinedTextField.kt#uh7d8r");
                                            if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2108828640, $changed5, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:215)");
                                                }
                                                OutlinedTextFieldDefaults.INSTANCE.m1636ContainerBoxnbWgWpA(z11, z12, mutableInteractionSource4, textFieldColors4, shape7, 0.0f, 0.0f, $composer6, ((i32 >> 9) & 14) | 12582912 | ((i33 >> 6) & 112) | ((i34 << 6) & 896) | ((i34 << 3) & 7168) | ((i34 << 9) & 57344), 96);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }), $composer5, (i29 & 14) | (($dirty7 << 3) & 112) | ((i29 >> 3) & 896) | ((i30 >> 12) & 7168) | (i30 & 57344) | ((i31 << 15) & 458752) | ((i30 << 9) & 3670016) | ((i29 << 3) & 29360128) | ((i29 << 3) & 234881024) | ((i29 << 3) & 1879048192), ((i29 >> 27) & 14) | 14155776 | ((i30 << 3) & 112) | ((i30 << 3) & 896) | ((i30 << 3) & 7168) | ((i31 << 6) & 57344), 32768);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, ($dirty5 & 14) | ($dirty5 & 112) | ($dirty5 & 7168) | (57344 & $dirty5) | ((i25 << 3) & 3670016) | ((i25 << 3) & 29360128) | ((i25 << 3) & 234881024) | ((i25 << 3) & 1879048192), ((i25 >> 27) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i25 >> 9) & 112) | ((i26 << 9) & 7168), 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            };
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer2, -1886965181, true, function215), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            interactionSource5 = interactionSource4;
            maxLines4 = maxLines3;
            isError3 = isError2;
            supportingText2 = supportingText;
            supportingText3 = suffix;
            suffix2 = prefix;
            prefix2 = trailingIcon;
            trailingIcon2 = leadingIcon;
            leadingIcon2 = placeholder;
            placeholder2 = label;
            enabled4 = enabled3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier4;
        final boolean z5 = enabled4;
        final boolean z6 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2 function216 = placeholder2;
        final Function2 function217 = leadingIcon2;
        final Function2 function218 = trailingIcon2;
        final Function2 function219 = prefix2;
        final Function2 function220 = suffix2;
        final Function2 function221 = supportingText3;
        final Function2 function222 = supportingText2;
        final boolean z7 = isError3;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z8 = singleLine2;
        final int i29 = maxLines4;
        final int i30 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors2 = colors3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3
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

            public final void invoke(Composer composer, int i31) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier7, z5, z6, textStyle5, function216, function217, function218, function219, function220, function221, function222, z7, visualTransformation4, keyboardOptions4, keyboardActions4, z8, i29, i30, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    public static final void OutlinedTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        int i3;
        int maxLines2;
        boolean readOnly2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int minLines2;
        int $dirty;
        int $dirty1;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        Shape shape3;
        int $dirty2;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Function2 prefix;
        Function2 label;
        Function2 suffix;
        Function2 supportingText;
        boolean isError2;
        int maxLines3;
        int $dirty3;
        int $dirty12;
        TextFieldColors colors2;
        TextStyle textStyle3;
        Object value$iv$iv;
        TextFieldColors colors3;
        TextStyle textStyle4;
        Composer $composer2;
        Shape shape4;
        MutableInteractionSource interactionSource5;
        int maxLines4;
        boolean isError3;
        Function2 supportingText2;
        Function2 supportingText3;
        Function2 suffix2;
        Function2 prefix2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        Function2 placeholder2;
        boolean enabled4;
        Modifier modifier4;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1570442800);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)304@16929L7,319@17681L39,320@17767L5,321@17830L8,329@18192L15,329@18126L2441:OutlinedTextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(textStyle)) {
                i7 = 131072;
                $dirty4 |= i7;
            }
            i7 = 65536;
            $dirty4 |= i7;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        int i12 = i & 128;
        if (i12 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        int i13 = i & 256;
        if (i13 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i14 = i & 512;
        if (i14 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        }
        int i15 = i & 1024;
        if (i15 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(function25) ? 4 : 2;
        }
        int i16 = i & 2048;
        if (i16 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty13 |= $composer3.changedInstance(function26) ? 32 : 16;
        }
        int i17 = i & 4096;
        if (i17 != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(function27) ? 256 : 128;
        }
        int i18 = i & 8192;
        if (i18 != 0) {
            $dirty13 |= 3072;
            i2 = i18;
        } else {
            i2 = i18;
            if (($changed1 & 7168) == 0) {
                $dirty13 |= $composer3.changed(isError) ? 2048 : 1024;
            }
        }
        int i19 = i & 16384;
        if (i19 != 0) {
            $dirty13 |= 24576;
            i3 = i19;
        } else if (($changed1 & 57344) == 0) {
            i3 = i19;
            $dirty13 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        } else {
            i3 = i19;
        }
        int i20 = i & 32768;
        if (i20 != 0) {
            $dirty13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty13 |= $composer3.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty13 |= $composer3.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i22 = i & 131072;
        if (i22 != 0) {
            $dirty13 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0) {
                maxLines2 = maxLines;
                if ($composer3.changed(maxLines2)) {
                    i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty13 |= i6;
                }
            } else {
                maxLines2 = maxLines;
            }
            i6 = 33554432;
            $dirty13 |= i6;
        } else {
            maxLines2 = maxLines;
        }
        int i23 = i & 524288;
        if (i23 != 0) {
            $dirty13 |= 805306368;
        } else if (($changed1 & 1879048192) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        }
        int i24 = i & 1048576;
        if (i24 != 0) {
            $dirty22 |= 6;
        } else if (($changed2 & 14) == 0) {
            $dirty22 |= $composer3.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 112) == 0) {
            if ((i & 2097152) == 0 && $composer3.changed(shape)) {
                i5 = 32;
                $dirty22 |= i5;
            }
            i5 = 16;
            $dirty22 |= i5;
        }
        if (($changed2 & 896) == 0) {
            if ((i & 4194304) == 0 && $composer3.changed(colors)) {
                i4 = 256;
                $dirty22 |= i4;
            }
            i4 = 128;
            $dirty22 |= i4;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && ($dirty22 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled4 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            placeholder2 = function2;
            leadingIcon2 = function22;
            trailingIcon2 = function23;
            prefix2 = function24;
            suffix2 = function25;
            supportingText3 = function26;
            supportingText2 = function27;
            isError3 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            minLines2 = minLines;
            interactionSource5 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            maxLines4 = maxLines2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i8 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled5 = i9 != 0 ? true : enabled;
                readOnly2 = i10 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) consume;
                    $dirty4 &= -458753;
                } else {
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    textStyle2 = textStyle;
                }
                Function2 label2 = i11 != 0 ? null : function2;
                Function2 placeholder3 = i12 != 0 ? null : function22;
                Function2 leadingIcon3 = i13 != 0 ? null : function23;
                Function2 trailingIcon3 = i14 != 0 ? null : function24;
                Function2 prefix3 = i15 != 0 ? null : function25;
                Function2 suffix3 = i16 != 0 ? null : function26;
                Function2 supportingText4 = i17 != 0 ? null : function27;
                boolean isError4 = i2 != 0 ? false : isError;
                visualTransformation2 = i3 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                keyboardOptions2 = i20 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                keyboardActions2 = i21 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i22 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty13 &= -234881025;
                }
                minLines2 = i23 != 0 ? 1 : minLines;
                if (i24 != 0) {
                    $dirty = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    $dirty1 = $dirty13;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty4;
                    $dirty1 = $dirty13;
                    interactionSource2 = interactionSource;
                }
                if ((2097152 & i) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty22 &= -113;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    shape3 = shape2;
                    $dirty2 = $dirty22 & (-897);
                    placeholder = placeholder3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    prefix = prefix3;
                    label = label2;
                    suffix = suffix3;
                    supportingText = supportingText4;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.m1637colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    textStyle3 = textStyle2;
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    shape3 = shape2;
                    $dirty2 = $dirty22;
                    placeholder = placeholder3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    prefix = prefix3;
                    label = label2;
                    suffix = suffix3;
                    supportingText = supportingText4;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = colors;
                    textStyle3 = textStyle2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 262144) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty22 &= -113;
                }
                if ((i & 4194304) != 0) {
                    $dirty22 &= -897;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                label = function2;
                placeholder = function22;
                leadingIcon = function23;
                trailingIcon = function24;
                prefix = function25;
                suffix = function26;
                supportingText = function27;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                minLines2 = minLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty12 = $dirty13;
                $dirty2 = $dirty22;
                maxLines3 = maxLines2;
                textStyle3 = textStyle;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1570442800, $dirty3, $dirty12, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:298)");
            }
            $composer3.startReplaceableGroup(1663544610);
            ComposerKt.sourceInformation($composer3, "*325@17990L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4747getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor$material3_release(enabled3, isError2, interactionSource4, $composer3, (($dirty3 >> 9) & 14) | (($dirty12 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m2959unboximpl();
            $composer3.endReplaceableGroup();
            final TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null));
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer3, ($dirty2 >> 6) & 14))};
            final Function2 function28 = label;
            final Modifier modifier6 = modifier3;
            final TextFieldColors textFieldColors = colors2;
            final boolean z = isError2;
            final int i25 = $dirty12;
            final int i26 = $dirty2;
            final boolean z2 = enabled3;
            final boolean z3 = readOnly2;
            final int $dirty5 = $dirty3;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActions keyboardActions3 = keyboardActions2;
            colors3 = colors2;
            final boolean z4 = singleLine2;
            textStyle4 = textStyle3;
            final int i27 = maxLines3;
            final int i28 = minLines2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Function2 function29 = placeholder;
            final Function2 function210 = leadingIcon;
            final Function2 function211 = trailingIcon;
            final Function2 function212 = prefix;
            final Function2 function213 = suffix;
            final Function2 function214 = supportingText;
            final Shape shape5 = shape3;
            Function2<Composer, Integer, Unit> function215 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5
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

                public final void invoke(Composer $composer4, int $changed3) {
                    Modifier modifier7;
                    ComposerKt.sourceInformation($composer4, "C349@19050L20,330@18219L2342:OutlinedTextField.kt#uh7d8r");
                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1830921872, $changed3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:329)");
                        }
                        if (function28 != null) {
                            modifier7 = PaddingKt.m488paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier6, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                        } else {
                            modifier7 = modifier6;
                        }
                        Modifier m515defaultMinSizeVpY3zN4 = SizeKt.m515defaultMinSizeVpY3zN4(modifier7, OutlinedTextFieldDefaults.INSTANCE.m1641getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m1640getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(textFieldColors.cursorColor$material3_release(z, $composer4, ((i25 >> 9) & 14) | ((i26 >> 3) & 112)).getValue().m2959unboximpl(), null);
                        final TextFieldValue textFieldValue = value;
                        final boolean z5 = z2;
                        final boolean z6 = z4;
                        final VisualTransformation visualTransformation4 = visualTransformation3;
                        final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        final boolean z7 = z;
                        final Function2<Composer, Integer, Unit> function216 = function28;
                        final Function2<Composer, Integer, Unit> function217 = function29;
                        final Function2<Composer, Integer, Unit> function218 = function210;
                        final Function2<Composer, Integer, Unit> function219 = function211;
                        final Function2<Composer, Integer, Unit> function220 = function212;
                        final Function2<Composer, Integer, Unit> function221 = function213;
                        final Function2<Composer, Integer, Unit> function222 = function214;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final int i29 = $dirty5;
                        final int i30 = i25;
                        final int i31 = i26;
                        final Shape shape6 = shape5;
                        BasicTextFieldKt.BasicTextField(value, onValueChange, m515defaultMinSizeVpY3zN4, z2, z3, mergedTextStyle, keyboardOptions3, keyboardActions3, z4, i27, i28, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, solidColor, ComposableLambdaKt.composableLambda($composer4, -757328870, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function223, Composer composer, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function223, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer5, int $changed4) {
                                Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                ComposerKt.sourceInformation($composer5, "C358@19486L1051:OutlinedTextField.kt#uh7d8r");
                                int $dirty6 = $changed4;
                                if (($changed4 & 14) == 0) {
                                    $dirty6 |= $composer5.changedInstance(innerTextField) ? 4 : 2;
                                }
                                int $dirty7 = $dirty6;
                                if (($dirty7 & 91) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-757328870, $dirty7, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:357)");
                                    }
                                    OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                    String text = TextFieldValue.this.getText();
                                    boolean z8 = z5;
                                    boolean z9 = z6;
                                    VisualTransformation visualTransformation5 = visualTransformation4;
                                    MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                    boolean z10 = z7;
                                    Function2<Composer, Integer, Unit> function223 = function216;
                                    Function2<Composer, Integer, Unit> function224 = function217;
                                    Function2<Composer, Integer, Unit> function225 = function218;
                                    Function2<Composer, Integer, Unit> function226 = function219;
                                    Function2<Composer, Integer, Unit> function227 = function220;
                                    Function2<Composer, Integer, Unit> function228 = function221;
                                    Function2<Composer, Integer, Unit> function229 = function222;
                                    TextFieldColors textFieldColors3 = textFieldColors2;
                                    final boolean z11 = z5;
                                    final boolean z12 = z7;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                    final Shape shape7 = shape6;
                                    final int i32 = i29;
                                    final int i33 = i30;
                                    final int i34 = i31;
                                    outlinedTextFieldDefaults.DecorationBox(text, innerTextField, z8, z9, visualTransformation5, mutableInteractionSource3, z10, function223, function224, function225, function226, function227, function228, function229, textFieldColors3, null, ComposableLambdaKt.composableLambda($composer5, 255570733, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer6, int $changed5) {
                                            ComposerKt.sourceInformation($composer6, "C375@20267L230:OutlinedTextField.kt#uh7d8r");
                                            if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(255570733, $changed5, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:374)");
                                                }
                                                OutlinedTextFieldDefaults.INSTANCE.m1636ContainerBoxnbWgWpA(z11, z12, mutableInteractionSource4, textFieldColors4, shape7, 0.0f, 0.0f, $composer6, ((i32 >> 9) & 14) | 12582912 | ((i33 >> 6) & 112) | ((i34 << 6) & 896) | ((i34 << 3) & 7168) | ((i34 << 9) & 57344), 96);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }), $composer5, (($dirty7 << 3) & 112) | ((i29 >> 3) & 896) | ((i30 >> 12) & 7168) | (i30 & 57344) | ((i31 << 15) & 458752) | ((i30 << 9) & 3670016) | ((i29 << 3) & 29360128) | ((i29 << 3) & 234881024) | ((i29 << 3) & 1879048192), ((i29 >> 27) & 14) | 14155776 | ((i30 << 3) & 112) | ((i30 << 3) & 896) | ((i30 << 3) & 7168) | ((i31 << 6) & 57344), 32768);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, ($dirty5 & 14) | ($dirty5 & 112) | ($dirty5 & 7168) | (57344 & $dirty5) | ((i25 << 3) & 3670016) | ((i25 << 3) & 29360128) | ((i25 << 3) & 234881024) | ((i25 << 3) & 1879048192), ((i25 >> 27) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i25 >> 9) & 112) | ((i26 << 9) & 7168), 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            };
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer2, 1830921872, true, function215), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            interactionSource5 = interactionSource4;
            maxLines4 = maxLines3;
            isError3 = isError2;
            supportingText2 = supportingText;
            supportingText3 = suffix;
            suffix2 = prefix;
            prefix2 = trailingIcon;
            trailingIcon2 = leadingIcon;
            leadingIcon2 = placeholder;
            placeholder2 = label;
            enabled4 = enabled3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier4;
        final boolean z5 = enabled4;
        final boolean z6 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2 function216 = placeholder2;
        final Function2 function217 = leadingIcon2;
        final Function2 function218 = trailingIcon2;
        final Function2 function219 = prefix2;
        final Function2 function220 = suffix2;
        final Function2 function221 = supportingText3;
        final Function2 function222 = supportingText2;
        final boolean z7 = isError3;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z8 = singleLine2;
        final int i29 = maxLines4;
        final int i30 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors2 = colors3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$6
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

            public final void invoke(Composer composer, int i31) {
                OutlinedTextFieldKt.OutlinedTextField(TextFieldValue.this, onValueChange, modifier7, z5, z6, textStyle5, function216, function217, function218, function219, function220, function221, function222, z7, visualTransformation4, keyboardOptions4, keyboardActions4, z8, i29, i30, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void OutlinedTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        boolean singleLine2;
        int maxLines2;
        int $dirty1;
        int minLines2;
        int $dirty;
        int maxLines3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        int $dirty12;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        int maxLines4;
        TextFieldColors colors2;
        Shape shape3;
        int $dirty2;
        TextStyle textStyle3;
        Function2 leadingIcon2;
        Function2 placeholder2;
        Function2 trailingIcon2;
        Function2 supportingText2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 label2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean readOnly2;
        int $dirty3;
        int $dirty13;
        Object value$iv$iv;
        Composer $composer2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1575225237);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)398@20920L7,411@21580L39,412@21666L5,413@21729L8,415@21746L771:OutlinedTextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty14 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(textStyle)) {
                i6 = 131072;
                $dirty4 |= i6;
            }
            i6 = 65536;
            $dirty4 |= i6;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changedInstance(label) ? 1048576 : 524288;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        }
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty14 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty14 |= $composer3.changedInstance(supportingText) ? 4 : 2;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty14 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty14 |= $composer3.changed(isError) ? 32 : 16;
        }
        int i16 = i & 4096;
        if (i16 != 0) {
            $dirty14 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty14 |= $composer3.changed(visualTransformation) ? 256 : 128;
        }
        int i17 = i & 8192;
        if (i17 != 0) {
            $dirty14 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty14 |= $composer3.changed(keyboardOptions) ? 2048 : 1024;
        }
        int i18 = i & 16384;
        if (i18 != 0) {
            $dirty14 |= 24576;
            i2 = i18;
        } else if (($changed1 & 57344) == 0) {
            i2 = i18;
            $dirty14 |= $composer3.changed(keyboardActions) ? 16384 : 8192;
        } else {
            i2 = i18;
        }
        int i19 = i & 32768;
        if (i19 != 0) {
            $dirty14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty14 |= $composer3.changed(singleLine) ? 131072 : 65536;
        }
        if (($changed1 & 3670016) == 0) {
            if ((i & 65536) == 0 && $composer3.changed(maxLines)) {
                i5 = 1048576;
                $dirty14 |= i5;
            }
            i5 = 524288;
            $dirty14 |= i5;
        }
        int i20 = i & 131072;
        if (i20 != 0) {
            $dirty14 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty14 |= $composer3.changed(minLines) ? 8388608 : 4194304;
        }
        int i21 = i & 262144;
        if (i21 != 0) {
            $dirty14 |= 100663296;
        } else if (($changed1 & 234881024) == 0) {
            $dirty14 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0 && $composer3.changed(shape)) {
                i4 = 536870912;
                $dirty14 |= i4;
            }
            i4 = 268435456;
            $dirty14 |= i4;
        }
        if (($changed2 & 14) == 0) {
            if ((i & 1048576) == 0 && $composer3.changed(colors)) {
                i3 = 4;
                $dirty22 |= i3;
            }
            i3 = 2;
            $dirty22 |= i3;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty14) == 306783378 && ($dirty22 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle3 = textStyle;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            supportingText2 = supportingText;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines4 = maxLines;
            minLines2 = minLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            colors2 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i8 != 0 ? true : enabled;
                boolean readOnly3 = i9 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    modifier2 = modifier4;
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) consume;
                    $dirty4 &= -458753;
                } else {
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i10 != 0 ? null : label;
                Function2 placeholder3 = i11 != 0 ? null : placeholder;
                Function2 leadingIcon3 = i12 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i13 != 0 ? null : trailingIcon;
                Function2 supportingText3 = i14 != 0 ? null : supportingText;
                boolean isError3 = i15 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i16 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i17 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i2 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i19 != 0 ? false : singleLine;
                if ((i & 65536) != 0) {
                    maxLines2 = $dirty14 & (-3670017);
                    $dirty1 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = $dirty14;
                    $dirty1 = maxLines;
                }
                minLines2 = i20 != 0 ? 1 : minLines;
                if (i21 != 0) {
                    $dirty = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    maxLines3 = $dirty1;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty4;
                    maxLines3 = $dirty1;
                    interactionSource2 = interactionSource;
                }
                if ((i & 524288) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty12 = maxLines2 & (-1879048193);
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                    $dirty12 = maxLines2;
                }
                if ((i & 1048576) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    maxLines4 = maxLines3;
                    shape3 = shape2;
                    $dirty2 = $dirty22 & (-15);
                    textStyle3 = textStyle2;
                    leadingIcon2 = leadingIcon3;
                    placeholder2 = placeholder3;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    label2 = label3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly3;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.m1637colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    $dirty3 = $dirty;
                    $dirty13 = $dirty12;
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    maxLines4 = maxLines3;
                    colors2 = colors;
                    shape3 = shape2;
                    $dirty2 = $dirty22;
                    textStyle3 = textStyle2;
                    leadingIcon2 = leadingIcon3;
                    placeholder2 = placeholder3;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    label2 = label3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly3;
                    $dirty3 = $dirty;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty14 &= -3670017;
                }
                if ((i & 524288) != 0) {
                    $dirty14 &= -1879048193;
                }
                if ((i & 1048576) != 0) {
                    $dirty22 &= -15;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                label2 = label;
                placeholder2 = placeholder;
                leadingIcon2 = leadingIcon;
                trailingIcon2 = trailingIcon;
                supportingText2 = supportingText;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines4 = maxLines;
                minLines2 = minLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty13 = $dirty14;
                $dirty2 = $dirty22;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1575225237, $dirty3, $dirty13, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:392)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, interactionSource4, shape3, colors2, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168) | ($dirty3 & 57344) | ($dirty3 & 458752) | ($dirty3 & 3670016) | ($dirty3 & 29360128) | ($dirty3 & 234881024) | ($dirty3 & 1879048192), (($dirty13 << 6) & 896) | 54 | (($dirty13 << 6) & 7168) | (($dirty13 << 6) & 57344) | (($dirty13 << 6) & 458752) | (($dirty13 << 6) & 3670016) | (($dirty13 << 6) & 29360128) | (($dirty13 << 6) & 234881024) | (($dirty13 << 6) & 1879048192), (($dirty13 >> 24) & 14) | (($dirty13 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z = enabled3;
        final boolean z2 = readOnly2;
        final TextStyle textStyle4 = textStyle3;
        final Function2 function2 = label2;
        final Function2 function22 = placeholder2;
        final Function2 function23 = leadingIcon2;
        final Function2 function24 = trailingIcon2;
        final Function2 function25 = supportingText2;
        final boolean z3 = isError2;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z4 = singleLine2;
        final int i22 = maxLines4;
        final int i23 = minLines2;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Shape shape4 = shape3;
        final TextFieldColors textFieldColors = colors2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$8
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

            public final void invoke(Composer composer, int i24) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, z, z2, textStyle4, function2, function22, function23, function24, function25, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i22, i23, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        boolean singleLine2;
        int maxLines2;
        int $dirty1;
        int minLines2;
        int $dirty;
        int maxLines3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        int $dirty12;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        int maxLines4;
        TextFieldColors colors2;
        Shape shape3;
        int $dirty2;
        TextStyle textStyle3;
        Function2 leadingIcon2;
        Function2 placeholder2;
        Function2 trailingIcon2;
        Function2 supportingText2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 label2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean readOnly2;
        int $dirty3;
        int $dirty13;
        Object value$iv$iv;
        Composer $composer2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-989817544);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)451@22886L7,464@23546L39,465@23632L5,466@23695L8,468@23712L771:OutlinedTextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty14 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(textStyle)) {
                i6 = 131072;
                $dirty4 |= i6;
            }
            i6 = 65536;
            $dirty4 |= i6;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changedInstance(label) ? 1048576 : 524288;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        }
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty14 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty14 |= $composer3.changedInstance(supportingText) ? 4 : 2;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty14 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty14 |= $composer3.changed(isError) ? 32 : 16;
        }
        int i16 = i & 4096;
        if (i16 != 0) {
            $dirty14 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty14 |= $composer3.changed(visualTransformation) ? 256 : 128;
        }
        int i17 = i & 8192;
        if (i17 != 0) {
            $dirty14 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty14 |= $composer3.changed(keyboardOptions) ? 2048 : 1024;
        }
        int i18 = i & 16384;
        if (i18 != 0) {
            $dirty14 |= 24576;
            i2 = i18;
        } else if (($changed1 & 57344) == 0) {
            i2 = i18;
            $dirty14 |= $composer3.changed(keyboardActions) ? 16384 : 8192;
        } else {
            i2 = i18;
        }
        int i19 = i & 32768;
        if (i19 != 0) {
            $dirty14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty14 |= $composer3.changed(singleLine) ? 131072 : 65536;
        }
        if (($changed1 & 3670016) == 0) {
            if ((i & 65536) == 0 && $composer3.changed(maxLines)) {
                i5 = 1048576;
                $dirty14 |= i5;
            }
            i5 = 524288;
            $dirty14 |= i5;
        }
        int i20 = i & 131072;
        if (i20 != 0) {
            $dirty14 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty14 |= $composer3.changed(minLines) ? 8388608 : 4194304;
        }
        int i21 = i & 262144;
        if (i21 != 0) {
            $dirty14 |= 100663296;
        } else if (($changed1 & 234881024) == 0) {
            $dirty14 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0 && $composer3.changed(shape)) {
                i4 = 536870912;
                $dirty14 |= i4;
            }
            i4 = 268435456;
            $dirty14 |= i4;
        }
        if (($changed2 & 14) == 0) {
            if ((i & 1048576) == 0 && $composer3.changed(colors)) {
                i3 = 4;
                $dirty22 |= i3;
            }
            i3 = 2;
            $dirty22 |= i3;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty14) == 306783378 && ($dirty22 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle3 = textStyle;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            supportingText2 = supportingText;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines4 = maxLines;
            minLines2 = minLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            colors2 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i8 != 0 ? true : enabled;
                boolean readOnly3 = i9 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    modifier2 = modifier4;
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) consume;
                    $dirty4 &= -458753;
                } else {
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i10 != 0 ? null : label;
                Function2 placeholder3 = i11 != 0 ? null : placeholder;
                Function2 leadingIcon3 = i12 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i13 != 0 ? null : trailingIcon;
                Function2 supportingText3 = i14 != 0 ? null : supportingText;
                boolean isError3 = i15 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i16 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i17 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i2 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i19 != 0 ? false : singleLine;
                if ((i & 65536) != 0) {
                    maxLines2 = $dirty14 & (-3670017);
                    $dirty1 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = $dirty14;
                    $dirty1 = maxLines;
                }
                minLines2 = i20 != 0 ? 1 : minLines;
                if (i21 != 0) {
                    $dirty = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    maxLines3 = $dirty1;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty4;
                    maxLines3 = $dirty1;
                    interactionSource2 = interactionSource;
                }
                if ((i & 524288) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty12 = maxLines2 & (-1879048193);
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                    $dirty12 = maxLines2;
                }
                if ((i & 1048576) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    maxLines4 = maxLines3;
                    shape3 = shape2;
                    $dirty2 = $dirty22 & (-15);
                    textStyle3 = textStyle2;
                    leadingIcon2 = leadingIcon3;
                    placeholder2 = placeholder3;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    label2 = label3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly3;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.m1637colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    $dirty3 = $dirty;
                    $dirty13 = $dirty12;
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    maxLines4 = maxLines3;
                    colors2 = colors;
                    shape3 = shape2;
                    $dirty2 = $dirty22;
                    textStyle3 = textStyle2;
                    leadingIcon2 = leadingIcon3;
                    placeholder2 = placeholder3;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    label2 = label3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly3;
                    $dirty3 = $dirty;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty14 &= -3670017;
                }
                if ((i & 524288) != 0) {
                    $dirty14 &= -1879048193;
                }
                if ((i & 1048576) != 0) {
                    $dirty22 &= -15;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                label2 = label;
                placeholder2 = placeholder;
                leadingIcon2 = leadingIcon;
                trailingIcon2 = trailingIcon;
                supportingText2 = supportingText;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines4 = maxLines;
                minLines2 = minLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty13 = $dirty14;
                $dirty2 = $dirty22;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-989817544, $dirty3, $dirty13, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:445)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, interactionSource4, shape3, colors2, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168) | ($dirty3 & 57344) | ($dirty3 & 458752) | ($dirty3 & 3670016) | ($dirty3 & 29360128) | ($dirty3 & 234881024) | ($dirty3 & 1879048192), (($dirty13 << 6) & 896) | 54 | (($dirty13 << 6) & 7168) | (($dirty13 << 6) & 57344) | (($dirty13 << 6) & 458752) | (($dirty13 << 6) & 3670016) | (($dirty13 << 6) & 29360128) | (($dirty13 << 6) & 234881024) | (($dirty13 << 6) & 1879048192), (($dirty13 >> 24) & 14) | (($dirty13 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z = enabled3;
        final boolean z2 = readOnly2;
        final TextStyle textStyle4 = textStyle3;
        final Function2 function2 = label2;
        final Function2 function22 = placeholder2;
        final Function2 function23 = leadingIcon2;
        final Function2 function24 = trailingIcon2;
        final Function2 function25 = supportingText2;
        final boolean z3 = isError2;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z4 = singleLine2;
        final int i22 = maxLines4;
        final int i23 = minLines2;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Shape shape4 = shape3;
        final TextFieldColors textFieldColors = colors2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$10
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

            public final void invoke(Composer composer, int i24) {
                OutlinedTextFieldKt.OutlinedTextField(TextFieldValue.this, onValueChange, modifier5, z, z2, textStyle4, function2, function22, function23, function24, function25, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i22, i23, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0678  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x081a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x09b5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x09c4  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x09ec  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0abc  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0ac8  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0b82  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0d0b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0e9e  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0e83  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0acc  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x09c7  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x09b8  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0800  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0291  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextFieldLayout(final androidx.compose.ui.Modifier r62, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r65, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, final boolean r70, final float r71, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Size, kotlin.Unit> r72, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, final androidx.compose.foundation.layout.PaddingValues r75, androidx.compose.runtime.Composer r76, final int r77, final int r78) {
        /*
            Method dump skipped, instructions count: 3811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-DHJA7U0, reason: not valid java name */
    public static final int m1646calculateWidthDHJA7U0(int leadingPlaceableWidth, int trailingPlaceableWidth, int prefixPlaceableWidth, int suffixPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, boolean isLabelInMiddleSection, long constraints, float density, PaddingValues paddingValues) {
        int affixTotalWidth = prefixPlaceableWidth + suffixPlaceableWidth;
        int focusedLabelWidth = 0;
        int middleSection = Math.max(textFieldPlaceableWidth + affixTotalWidth, Math.max(placeholderPlaceableWidth + affixTotalWidth, isLabelInMiddleSection ? labelPlaceableWidth : 0));
        int wrappedWidth = leadingPlaceableWidth + middleSection + trailingPlaceableWidth;
        if (!isLabelInMiddleSection) {
            float arg0$iv = paddingValues.mo435calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
            float other$iv = paddingValues.mo436calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
            float labelHorizontalPadding = Dp.m5218constructorimpl(arg0$iv + other$iv) * density;
            focusedLabelWidth = labelPlaceableWidth + MathKt.roundToInt(labelHorizontalPadding);
        }
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m5176getMinWidthimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-DHJA7U0, reason: not valid java name */
    public static final int m1645calculateHeightDHJA7U0(int leadingPlaceableHeight, int trailingPlaceableHeight, int prefixPlaceableHeight, int suffixPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, int supportingPlaceableHeight, long constraints, float density, PaddingValues paddingValues) {
        int inputFieldHeight = Math.max(textFieldPlaceableHeight, placeholderPlaceableHeight);
        float topPadding = paddingValues.getTop() * density;
        float bottomPadding = paddingValues.getBottom() * density;
        float middleSectionHeight = inputFieldHeight + bottomPadding + Math.max(topPadding, labelPlaceableHeight / 2.0f);
        return Math.max(Constraints.m5175getMinHeightimpl(constraints), ComparisonsKt.maxOf(leadingPlaceableHeight, trailingPlaceableHeight, prefixPlaceableHeight, suffixPlaceableHeight, MathKt.roundToInt(middleSectionHeight)) + supportingPlaceableHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int totalHeight, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int i;
        float widthOrZero;
        Placeable.PlacementScope.m4243place70tqf50$default($this$place, containerPlaceable, IntOffset.INSTANCE.m5346getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        int startPadding = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * density);
        float iconPadding = TextFieldImplKt.getHorizontalIconPadding() * density;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                i = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                i = topPadding;
            }
            int startPositionY = i;
            int positionY = MathHelpersKt.lerp(startPositionY, -(labelPlaceable.getHeight() / 2), animationProgress);
            if (leadingPlaceable == null) {
                widthOrZero = 0.0f;
            } else {
                widthOrZero = (TextFieldImplKt.widthOrZero(leadingPlaceable) - iconPadding) * (1 - animationProgress);
            }
            int positionX = MathKt.roundToInt(widthOrZero) + startPadding;
            Placeable.PlacementScope.placeRelative$default($this$place, labelPlaceable, positionX, positionY, 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, prefixPlaceable), 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, suffixPlaceable), 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, textHorizontalPosition, place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, textFieldPlaceable), 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeholderPlaceable, textHorizontalPosition, place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, placeholderPlaceable), 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable $labelPlaceable, Placeable placeable) {
        int i;
        if ($singleLine) {
            i = Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), height);
        } else {
            i = topPadding;
        }
        return Math.max(i, TextFieldImplKt.heightOrZero($labelPlaceable) / 2);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1647outlineCutout12SF9DM(Modifier outlineCutout, final long labelSize, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                float f;
                float right;
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                float labelWidth = Size.m2779getWidthimpl(labelSize);
                if (labelWidth > 0.0f) {
                    f = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                    float innerPadding = drawWithContent.mo329toPx0680j_4(f);
                    float leftLtr = drawWithContent.mo329toPx0680j_4(paddingValues.mo435calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - innerPadding;
                    float f2 = 2;
                    float rightLtr = leftLtr + labelWidth + (f2 * innerPadding);
                    float left = WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1 ? Size.m2779getWidthimpl(drawWithContent.mo3492getSizeNHjbRc()) - rightLtr : RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        right = Size.m2779getWidthimpl(drawWithContent.mo3492getSizeNHjbRc()) - RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    } else {
                        right = rightLtr;
                    }
                    float labelHeight = Size.m2776getHeightimpl(labelSize);
                    ContentDrawScope $this$clipRect_u2drOu3jXo$iv = drawWithContent;
                    float top$iv = (-labelHeight) / f2;
                    float bottom$iv = labelHeight / f2;
                    int clipOp$iv = ClipOp.INSTANCE.m2937getDifferencertfAjoo();
                    DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$clipRect_u2drOu3jXo$iv.getDrawContext();
                    long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3417getSizeNHjbRc();
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                    DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                    $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo3420clipRectN_I0leg(left, top$iv, right, bottom$iv, clipOp$iv);
                    drawWithContent.drawContent();
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv);
                    return;
                }
                drawWithContent.drawContent();
            }
        });
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
