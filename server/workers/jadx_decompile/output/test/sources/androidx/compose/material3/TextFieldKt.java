package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Placeable;
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

/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010-\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010/\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001aì\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001au\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001aU\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020$2\u0006\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u0014\u0010U\u001a\u00020\f*\u00020\f2\u0006\u0010V\u001a\u00020WH\u0000\u001a\u009a\u0001\u0010X\u001a\u00020\u0006*\u00020Y2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010_\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010]2\b\u0010a\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]2\b\u0010c\u001a\u0004\u0018\u00010]2\u0006\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010]2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020$2\u0006\u0010g\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010H\u001a\u000206H\u0002\u001a\u0080\u0001\u0010h\u001a\u00020\u0006*\u00020Y2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$2\u0006\u0010i\u001a\u00020]2\b\u0010_\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010]2\b\u0010a\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]2\b\u0010c\u001a\u0004\u0018\u00010]2\u0006\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010]2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010H\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006j"}, d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "isLabelFocused", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m5218constructorimpl(8);

    public static final void TextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
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
        Function2 suffix;
        Function2 label;
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
        Composer $composer3 = $composer.startRestartGroup(-676242365);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)171@8945L7,186@9697L39,187@9775L5,188@9830L8,196@10192L15,196@10126L1825:TextField.kt#uh7d8r");
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
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
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
                    suffix = suffix3;
                    label = label2;
                    supportingText = supportingText4;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = TextFieldDefaults.INSTANCE.m1842colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
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
                    suffix = suffix3;
                    label = label2;
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
                ComposerKt.traceEventStart(-676242365, $dirty3, $dirty12, "androidx.compose.material3.TextField (TextField.kt:165)");
            }
            $composer3.startReplaceableGroup(-1263331616);
            ComposerKt.sourceInformation($composer3, "*192@9990L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4747getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor$material3_release(enabled3, isError2, interactionSource4, $composer3, (($dirty3 >> 9) & 14) | (($dirty12 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m2959unboximpl();
            $composer3.endReplaceableGroup();
            final TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null));
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer3, ($dirty2 >> 6) & 14))};
            final Modifier modifier6 = modifier3;
            final TextFieldColors textFieldColors = colors2;
            final boolean z = isError2;
            final int i25 = $dirty12;
            final int i26 = $dirty2;
            final boolean z2 = enabled3;
            final boolean z3 = readOnly2;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final int $dirty5 = $dirty3;
            final KeyboardActions keyboardActions3 = keyboardActions2;
            final boolean z4 = singleLine2;
            colors3 = colors2;
            final int i27 = maxLines3;
            textStyle4 = textStyle3;
            final int i28 = minLines2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Function2 function28 = label;
            final Function2 function29 = placeholder;
            final Function2 function210 = leadingIcon;
            final Function2 function211 = trailingIcon;
            final Function2 function212 = prefix;
            final Function2 function213 = suffix;
            final Function2 function214 = supportingText;
            final Shape shape5 = shape3;
            Function2<Composer, Integer, Unit> function215 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$2
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
                    ComposerKt.sourceInformation($composer4, "C208@10657L20,197@10219L1726:TextField.kt#uh7d8r");
                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1859145987, $changed3, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:196)");
                        }
                        Modifier m515defaultMinSizeVpY3zN4 = SizeKt.m515defaultMinSizeVpY3zN4(Modifier.this, TextFieldDefaults.INSTANCE.m1848getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1847getMinHeightD9Ej5fM());
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
                        final Shape shape6 = shape5;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final int i29 = $dirty5;
                        final int i30 = i25;
                        final int i31 = i26;
                        BasicTextFieldKt.BasicTextField(value, onValueChange, m515defaultMinSizeVpY3zN4, z2, z3, mergedTextStyle, keyboardOptions3, keyboardActions3, z4, i27, i28, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, solidColor, ComposableLambdaKt.composableLambda($composer4, -288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$2.1
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
                                ComposerKt.sourceInformation($composer5, "C218@11178L743:TextField.kt#uh7d8r");
                                int $dirty6 = $changed4;
                                if (($changed4 & 14) == 0) {
                                    $dirty6 |= $composer5.changedInstance(innerTextField) ? 4 : 2;
                                }
                                int $dirty7 = $dirty6;
                                if (($dirty7 & 91) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-288211827, $dirty7, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:216)");
                                    }
                                    TextFieldDefaults.INSTANCE.DecorationBox(str, innerTextField, z5, z6, visualTransformation4, mutableInteractionSource2, z7, function216, function217, function218, function219, function220, function221, function222, shape6, textFieldColors2, null, null, $composer5, ((i29 >> 3) & 896) | (i29 & 14) | (($dirty7 << 3) & 112) | ((i30 >> 12) & 7168) | (i30 & 57344) | ((i31 << 15) & 458752) | ((i30 << 9) & 3670016) | ((i29 << 3) & 29360128) | ((i29 << 3) & 234881024) | ((i29 << 3) & 1879048192), ((i29 >> 27) & 14) | 100663296 | ((i30 << 3) & 112) | ((i30 << 3) & 896) | ((i30 << 3) & 7168) | ((i31 << 9) & 57344) | ((i31 << 9) & 458752), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
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
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer2, 1859145987, true, function215), $composer2, 56);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$3
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
                TextFieldKt.TextField(value, onValueChange, modifier7, z5, z6, textStyle5, function216, function217, function218, function219, function220, function221, function222, z7, visualTransformation4, keyboardOptions4, keyboardActions4, z8, i29, i30, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    public static final void TextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
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
        Function2 suffix;
        Function2 label;
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
        Composer $composer3 = $composer.startRestartGroup(-1268528240);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)316@17035L7,331@17787L39,332@17865L5,333@17920L8,341@18282L15,341@18216L1830:TextField.kt#uh7d8r");
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
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
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
                    suffix = suffix3;
                    label = label2;
                    supportingText = supportingText4;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = TextFieldDefaults.INSTANCE.m1842colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
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
                    suffix = suffix3;
                    label = label2;
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
                ComposerKt.traceEventStart(-1268528240, $dirty3, $dirty12, "androidx.compose.material3.TextField (TextField.kt:310)");
            }
            $composer3.startReplaceableGroup(-1263323526);
            ComposerKt.sourceInformation($composer3, "*337@18080L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4747getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor$material3_release(enabled3, isError2, interactionSource4, $composer3, (($dirty3 >> 9) & 14) | (($dirty12 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m2959unboximpl();
            $composer3.endReplaceableGroup();
            final TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null));
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer3, ($dirty2 >> 6) & 14))};
            final Modifier modifier6 = modifier3;
            final TextFieldColors textFieldColors = colors2;
            final boolean z = isError2;
            final int i25 = $dirty12;
            final int i26 = $dirty2;
            final boolean z2 = enabled3;
            final boolean z3 = readOnly2;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final int $dirty5 = $dirty3;
            final KeyboardActions keyboardActions3 = keyboardActions2;
            final boolean z4 = singleLine2;
            colors3 = colors2;
            final int i27 = maxLines3;
            textStyle4 = textStyle3;
            final int i28 = minLines2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Function2 function28 = label;
            final Function2 function29 = placeholder;
            final Function2 function210 = leadingIcon;
            final Function2 function211 = trailingIcon;
            final Function2 function212 = prefix;
            final Function2 function213 = suffix;
            final Function2 function214 = supportingText;
            final Shape shape5 = shape3;
            Function2<Composer, Integer, Unit> function215 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$5
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
                    ComposerKt.sourceInformation($composer4, "C353@18747L20,342@18309L1731:TextField.kt#uh7d8r");
                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1163788208, $changed3, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:341)");
                        }
                        Modifier m515defaultMinSizeVpY3zN4 = SizeKt.m515defaultMinSizeVpY3zN4(Modifier.this, TextFieldDefaults.INSTANCE.m1848getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1847getMinHeightD9Ej5fM());
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
                        final Shape shape6 = shape5;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final int i29 = $dirty5;
                        final int i30 = i25;
                        final int i31 = i26;
                        BasicTextFieldKt.BasicTextField(value, onValueChange, m515defaultMinSizeVpY3zN4, z2, z3, mergedTextStyle, keyboardOptions3, keyboardActions3, z4, i27, i28, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, solidColor, ComposableLambdaKt.composableLambda($composer4, 1751957978, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$5.1
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
                                ComposerKt.sourceInformation($composer5, "C363@19268L748:TextField.kt#uh7d8r");
                                int $dirty6 = $changed4;
                                if (($changed4 & 14) == 0) {
                                    $dirty6 |= $composer5.changedInstance(innerTextField) ? 4 : 2;
                                }
                                int $dirty7 = $dirty6;
                                if (($dirty7 & 91) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1751957978, $dirty7, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:361)");
                                    }
                                    TextFieldDefaults.INSTANCE.DecorationBox(TextFieldValue.this.getText(), innerTextField, z5, z6, visualTransformation4, mutableInteractionSource2, z7, function216, function217, function218, function219, function220, function221, function222, shape6, textFieldColors2, null, null, $composer5, ((i29 >> 3) & 896) | (($dirty7 << 3) & 112) | ((i30 >> 12) & 7168) | (i30 & 57344) | ((i31 << 15) & 458752) | ((i30 << 9) & 3670016) | ((i29 << 3) & 29360128) | ((i29 << 3) & 234881024) | ((i29 << 3) & 1879048192), ((i29 >> 27) & 14) | 100663296 | ((i30 << 3) & 112) | ((i30 << 3) & 896) | ((i30 << 3) & 7168) | ((i31 << 9) & 57344) | ((i31 << 9) & 458752), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
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
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer2, -1163788208, true, function215), $composer2, 56);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$6
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
                TextFieldKt.TextField(TextFieldValue.this, onValueChange, modifier7, z5, z6, textStyle5, function216, function217, function218, function219, function220, function221, function222, z7, visualTransformation4, keyboardOptions4, keyboardActions4, z8, i29, i30, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void TextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
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
        Composer $composer3 = $composer.startRestartGroup(-1500728277);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)395@20391L7,408@21051L39,409@21129L5,410@21184L8,412@21201L763:TextField.kt#uh7d8r");
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
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
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
                    colors2 = TextFieldDefaults.INSTANCE.m1842colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
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
                ComposerKt.traceEventStart(-1500728277, $dirty3, $dirty13, "androidx.compose.material3.TextField (TextField.kt:389)");
            }
            $composer2 = $composer3;
            TextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, interactionSource4, shape3, colors2, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168) | ($dirty3 & 57344) | ($dirty3 & 458752) | ($dirty3 & 3670016) | ($dirty3 & 29360128) | ($dirty3 & 234881024) | ($dirty3 & 1879048192), (($dirty13 << 6) & 896) | 54 | (($dirty13 << 6) & 7168) | (($dirty13 << 6) & 57344) | (($dirty13 << 6) & 458752) | (($dirty13 << 6) & 3670016) | (($dirty13 << 6) & 29360128) | (($dirty13 << 6) & 234881024) | (($dirty13 << 6) & 1879048192), (($dirty13 >> 24) & 14) | (($dirty13 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$8
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
                TextFieldKt.TextField(value, onValueChange, modifier5, z, z2, textStyle4, function2, function22, function23, function24, function25, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i22, i23, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void TextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
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
        Composer $composer3 = $composer.startRestartGroup(1523846136);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)448@22325L7,461@22985L39,462@23063L5,463@23118L8,465@23135L763:TextField.kt#uh7d8r");
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
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
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
                    colors2 = TextFieldDefaults.INSTANCE.m1842colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
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
                ComposerKt.traceEventStart(1523846136, $dirty3, $dirty13, "androidx.compose.material3.TextField (TextField.kt:442)");
            }
            $composer2 = $composer3;
            TextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, interactionSource4, shape3, colors2, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168) | ($dirty3 & 57344) | ($dirty3 & 458752) | ($dirty3 & 3670016) | ($dirty3 & 29360128) | ($dirty3 & 234881024) | ($dirty3 & 1879048192), (($dirty13 << 6) & 896) | 54 | (($dirty13 << 6) & 7168) | (($dirty13 << 6) & 57344) | (($dirty13 << 6) & 458752) | (($dirty13 << 6) & 3670016) | (($dirty13 << 6) & 29360128) | (($dirty13 << 6) & 234881024) | (($dirty13 << 6) & 1879048192), (($dirty13 >> 24) & 14) | (($dirty13 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$10
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
                TextFieldKt.TextField(TextFieldValue.this, onValueChange, modifier5, z, z2, textStyle4, function2, function22, function23, function24, function25, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i22, i23, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0803  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0997  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0b3e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0b4d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0b75  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0c48  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0c54  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0d0b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0ea5  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0e8a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0c58  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0b50  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0b41  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0b22  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x07e9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0279  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextFieldLayout(final androidx.compose.ui.Modifier r63, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r65, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, final boolean r71, final float r72, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, final androidx.compose.foundation.layout.PaddingValues r75, androidx.compose.runtime.Composer r76, final int r77, final int r78) {
        /*
            Method dump skipped, instructions count: 3821
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final int m1869calculateWidthyeHjK3Y(int leadingWidth, int trailingWidth, int prefixWidth, int suffixWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        int affixTotalWidth = prefixWidth + suffixWidth;
        int middleSection = Math.max(textFieldWidth + affixTotalWidth, Math.max(placeholderWidth + affixTotalWidth, labelWidth));
        int wrappedWidth = leadingWidth + middleSection + trailingWidth;
        return Math.max(wrappedWidth, Constraints.m5176getMinWidthimpl(constraints));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m1868calculateHeightmKXJcVc(int textFieldHeight, int labelHeight, int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int placeholderHeight, int supportingHeight, boolean isLabelFocused, long constraints, float density, PaddingValues paddingValues) {
        float m5218constructorimpl;
        float middleSectionHeight;
        boolean hasLabel = labelHeight > 0;
        if (!hasLabel || isLabelFocused) {
            float arg0$iv = paddingValues.getTop();
            float other$iv = paddingValues.getBottom();
            m5218constructorimpl = Dp.m5218constructorimpl(arg0$iv + other$iv);
        } else {
            float arg0$iv2 = TextFieldImplKt.getTextFieldPadding();
            m5218constructorimpl = Dp.m5218constructorimpl(2 * arg0$iv2);
        }
        float arg0$iv3 = density * m5218constructorimpl;
        if (hasLabel && isLabelFocused) {
            middleSectionHeight = labelHeight + arg0$iv3 + Math.max(textFieldHeight, placeholderHeight);
        } else {
            middleSectionHeight = Math.max(labelHeight, Math.max(textFieldHeight, placeholderHeight)) + arg0$iv3;
        }
        return Math.max(Constraints.m5175getMinHeightimpl(constraints), ComparisonsKt.maxOf(leadingHeight, trailingHeight, prefixHeight, suffixHeight, MathKt.roundToInt(middleSectionHeight)) + supportingHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int totalHeight, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        int roundToInt;
        Placeable.PlacementScope.m4243place70tqf50$default($this$placeWithLabel, containerPlaceable, IntOffset.INSTANCE.m5346getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                roundToInt = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                roundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * density);
            }
            int startPosition = roundToInt;
            int distance = startPosition - labelEndPosition;
            int positionY = startPosition - MathKt.roundToInt(distance * animationProgress);
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, labelPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), positionY, 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), textPosition, 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, textHorizontalPosition, textPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, textHorizontalPosition, textPosition, 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int totalHeight, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        Placeable.PlacementScope.m4243place70tqf50$default($this$placeWithoutLabel, containerPlaceable, IntOffset.INSTANCE.m5346getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, prefixPlaceable), 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, suffixPlaceable), 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, textHorizontalPosition, placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, textPlaceable), 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, textHorizontalPosition, placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, placeholderPlaceable), 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable placeable) {
        if ($singleLine) {
            return Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), height);
        }
        return topPadding;
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, final BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter($this$drawIndicatorLine, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        final float strokeWidthDp = indicatorBorder.getWidth();
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt$drawIndicatorLine$1
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
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                drawWithContent.drawContent();
                if (Dp.m5223equalsimpl0(strokeWidthDp, Dp.INSTANCE.m5236getHairlineD9Ej5fM())) {
                    return;
                }
                float strokeWidth = strokeWidthDp * drawWithContent.getDensity();
                float y = Size.m2776getHeightimpl(drawWithContent.mo3492getSizeNHjbRc()) - (strokeWidth / 2);
                DrawScope.m3478drawLine1RTmtNc$default(drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, y), OffsetKt.Offset(Size.m2779getWidthimpl(drawWithContent.mo3492getSizeNHjbRc()), y), strokeWidth, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }
}
