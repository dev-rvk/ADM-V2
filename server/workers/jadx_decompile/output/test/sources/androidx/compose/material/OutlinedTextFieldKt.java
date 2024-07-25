package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import androidx.compose.ui.text.style.TextMotion;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010.\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010/\u001aÄ\u0001\u00100\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\t0\r2\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0002\u0010;\u001a]\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a]\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010F\u001a)\u0010N\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010O\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a|\u0010R\u001a\u00020\t*\u00020S2\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010\\\u001a\u00020W2\u0006\u00104\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010D\u001a\u0002052\u0006\u0010]\u001a\u00020^2\u0006\u00109\u001a\u00020:H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006_"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-O3s9Psw", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = Dp.m5218constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m5218constructorimpl(8);

    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean readOnly2;
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
        CornerBasedShape shape2;
        int $dirty12;
        int $dirty2;
        MutableInteractionSource interactionSource3;
        int maxLines4;
        Function2 leadingIcon;
        Function2 trailingIcon;
        VisualTransformation visualTransformation2;
        Function2 label;
        KeyboardOptions keyboardOptions2;
        Function2 placeholder;
        KeyboardActions keyboardActions2;
        Modifier modifier3;
        boolean enabled3;
        int $dirty3;
        TextFieldColors colors2;
        TextStyle textStyle3;
        boolean isError2;
        Shape shape3;
        Object value$iv$iv;
        TextFieldColors colors3;
        Shape shape4;
        boolean isError3;
        Composer $composer2;
        TextStyle textStyle4;
        boolean enabled4;
        Modifier modifier4;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions3;
        int maxLines5;
        Function2 placeholder2;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        MutableInteractionSource interactionSource4;
        VisualTransformation visualTransformation3;
        Function2 label2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-621914704);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)139@7767L7,151@8373L39,152@8447L6,153@8509L25,173@9280L24,182@9646L20,162@8837L2051:OutlinedTextField.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
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
            $dirty4 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        }
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty13 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i16 = i & 4096;
        if (i16 != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changed(keyboardOptions) ? 256 : 128;
        }
        int i17 = i & 8192;
        if (i17 != 0) {
            $dirty13 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty13 |= $composer3.changed(keyboardActions) ? 2048 : 1024;
        }
        int i18 = i & 16384;
        if (i18 != 0) {
            $dirty13 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        if (($changed1 & 458752) == 0) {
            if ((i & 32768) == 0 && $composer3.changed(maxLines)) {
                i5 = 131072;
                $dirty13 |= i5;
            }
            i5 = 65536;
            $dirty13 |= i5;
        }
        int i19 = i & 65536;
        if (i19 != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 1048576 : 524288;
        }
        int i20 = i & 131072;
        if (i20 != 0) {
            $dirty13 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0 && $composer3.changed(shape)) {
                i4 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty13 |= i4;
            }
            i4 = 33554432;
            $dirty13 |= i4;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0 && $composer3.changed(colors)) {
                i3 = 536870912;
                $dirty13 |= i3;
            }
            i3 = 268435456;
            $dirty13 |= i3;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled4 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            label2 = function2;
            placeholder2 = function22;
            leadingIcon2 = function23;
            trailingIcon2 = function24;
            isError3 = isError;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
            singleLine2 = singleLine;
            maxLines5 = maxLines;
            minLines2 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i7 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled5 = i8 != 0 ? true : enabled;
                readOnly2 = i9 != 0 ? false : readOnly;
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
                Function2 label3 = i10 != 0 ? null : function2;
                Function2 placeholder3 = i11 != 0 ? null : function22;
                Function2 leadingIcon3 = i12 != 0 ? null : function23;
                Function2 trailingIcon3 = i13 != 0 ? null : function24;
                boolean isError4 = i14 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i15 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i16 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i17 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i18 != 0 ? false : singleLine;
                if ((32768 & i) != 0) {
                    maxLines2 = $dirty13 & (-458753);
                    $dirty1 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = $dirty13;
                    $dirty1 = maxLines;
                }
                minLines2 = i19 != 0 ? 1 : minLines;
                if (i20 != 0) {
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
                if ((262144 & i) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty12 = maxLines2 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty12 = maxLines2;
                }
                if ((i & 524288) != 0) {
                    MutableInteractionSource interactionSource5 = interactionSource2;
                    $dirty2 = 1;
                    interactionSource3 = interactionSource5;
                    maxLines4 = maxLines3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    visualTransformation2 = visualTransformation4;
                    label = label3;
                    keyboardOptions2 = keyboardOptions4;
                    placeholder = placeholder3;
                    keyboardActions2 = keyboardActions4;
                    colors2 = TextFieldDefaults.INSTANCE.m1241outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    $dirty3 = $dirty;
                    textStyle3 = textStyle2;
                    isError2 = isError4;
                    shape3 = shape2;
                    $dirty13 = $dirty12 & (-1879048193);
                } else {
                    MutableInteractionSource interactionSource6 = interactionSource2;
                    $dirty2 = 1;
                    interactionSource3 = interactionSource6;
                    maxLines4 = maxLines3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    visualTransformation2 = visualTransformation4;
                    label = label3;
                    keyboardOptions2 = keyboardOptions4;
                    placeholder = placeholder3;
                    keyboardActions2 = keyboardActions4;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    $dirty3 = $dirty;
                    colors2 = colors;
                    textStyle3 = textStyle2;
                    isError2 = isError4;
                    shape3 = shape2;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    i2 = -458753;
                    $dirty4 &= -458753;
                } else {
                    i2 = -458753;
                }
                if ((32768 & i) != 0) {
                    $dirty13 &= i2;
                }
                if ((262144 & i) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty13 &= -1879048193;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                label = function2;
                placeholder = function22;
                leadingIcon = function23;
                trailingIcon = function24;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines4 = maxLines;
                minLines2 = minLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty2 = 1;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-621914704, $dirty3, $dirty13, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:133)");
            }
            $composer3.startReplaceableGroup(1961395213);
            ComposerKt.sourceInformation($composer3, "*157@8686L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4747getColor0d7_KjU();
            long textColor = (($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $dirty2 : 0) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor(enabled3, $composer3, (($dirty3 >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m2959unboximpl();
            $composer3.endReplaceableGroup();
            TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final boolean z = enabled3;
            final boolean z2 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final boolean z3 = isError2;
            final Function2 function25 = label;
            final Function2 function26 = placeholder;
            final Function2 function27 = leadingIcon;
            final Function2 function28 = trailingIcon;
            final TextFieldColors textFieldColors = colors2;
            final int i21 = $dirty3;
            final int i22 = $dirty13;
            final Shape shape5 = shape3;
            colors3 = colors2;
            shape4 = shape3;
            isError3 = isError2;
            $composer2 = $composer3;
            textStyle4 = textStyle3;
            enabled4 = enabled3;
            modifier4 = modifier3;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m515defaultMinSizeVpY3zN4(BackgroundKt.m162backgroundbw27NRU(label != null ? PaddingKt.m488paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }
            }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null) : modifier3, colors2.backgroundColor(enabled3, $composer3, (($dirty3 >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m2959unboximpl(), shape3), TextFieldDefaults.INSTANCE.m1238getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1237getMinHeightD9Ej5fM()), enabled3, readOnly2, mergedTextStyle, keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, new SolidColor(colors2.cursorColor(isError2, $composer3, ($dirty13 & 14) | (($dirty13 >> 24) & 112)).getValue().m2959unboximpl(), null), ComposableLambdaKt.composableLambda($composer3, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function29, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function29, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation($composer4, "C191@10038L834:OutlinedTextField.kt#jmzs0o");
                    int $dirty5 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty5 |= $composer4.changedInstance(innerTextField) ? 4 : 2;
                    }
                    int $dirty6 = $dirty5;
                    if (($dirty6 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1710364390, $dirty6, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:190)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = value;
                        boolean z4 = z;
                        boolean z5 = z2;
                        VisualTransformation visualTransformation6 = visualTransformation5;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        boolean z6 = z3;
                        Function2<Composer, Integer, Unit> function29 = function25;
                        Function2<Composer, Integer, Unit> function210 = function26;
                        Function2<Composer, Integer, Unit> function211 = function27;
                        Function2<Composer, Integer, Unit> function212 = function28;
                        TextFieldColors textFieldColors2 = textFieldColors;
                        final boolean z7 = z;
                        final boolean z8 = z3;
                        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                        final TextFieldColors textFieldColors3 = textFieldColors;
                        final Shape shape6 = shape5;
                        final int i23 = i21;
                        final int i24 = i22;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z4, z5, visualTransformation6, mutableInteractionSource2, z6, function29, function210, function211, function212, textFieldColors2, null, ComposableLambdaKt.composableLambda($composer4, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C205@10637L203:OutlinedTextField.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1823843281, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:204)");
                                    }
                                    TextFieldDefaults.INSTANCE.m1235BorderBoxnbWgWpA(z7, z8, mutableInteractionSource3, textFieldColors3, shape6, 0.0f, 0.0f, $composer5, ((i23 >> 9) & 14) | 12582912 | ((i24 << 3) & 112) | ((i24 >> 15) & 896) | ((i24 >> 18) & 7168) | ((i24 >> 12) & 57344), 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, (i21 & 14) | (($dirty6 << 3) & 112) | ((i21 >> 3) & 896) | ((i22 >> 3) & 7168) | ((i22 << 9) & 57344) | ((i22 >> 6) & 458752) | ((i22 << 18) & 3670016) | ((i21 << 3) & 29360128) | ((i21 << 3) & 234881024) | ((i21 << 3) & 1879048192), ((i21 >> 27) & 14) | 27648 | ((i22 >> 24) & 112), 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 7168) | ($dirty3 & 57344) | (($dirty13 << 12) & 3670016) | (($dirty13 << 12) & 29360128) | (($dirty13 << 12) & 234881024) | (($dirty13 << 12) & 1879048192), (($dirty13 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty13 & 112) | (($dirty13 >> 12) & 7168), 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            maxLines5 = maxLines4;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            interactionSource4 = interactionSource3;
            visualTransformation3 = visualTransformation2;
            label2 = label;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z4 = enabled4;
        final boolean z5 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2 function29 = label2;
        final Function2 function210 = placeholder2;
        final Function2 function211 = leadingIcon2;
        final Function2 function212 = trailingIcon2;
        final boolean z6 = isError3;
        final VisualTransformation visualTransformation6 = visualTransformation3;
        final KeyboardOptions keyboardOptions5 = keyboardOptions3;
        final KeyboardActions keyboardActions5 = keyboardActions3;
        final boolean z7 = singleLine2;
        final int i23 = maxLines5;
        final int i24 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors2 = colors3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$4
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

            public final void invoke(Composer composer, int i25) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier6, z4, z5, textStyle5, function29, function210, function211, function212, z6, visualTransformation6, keyboardOptions5, keyboardActions5, z7, i23, i24, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void OutlinedTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        int $dirty;
        TextStyle textStyle3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        CornerBasedShape shape2;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        TextFieldColors colors2;
        TextStyle textStyle4;
        Shape shape3;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 placeholder2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        Function2 label2;
        boolean singleLine2;
        int maxLines2;
        boolean readOnly2;
        int $dirty2;
        int maxLines3;
        Object value$iv$iv;
        Composer $composer2;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)229@11249L7,240@11809L39,241@11883L6,242@11945L25,244@11979L416:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(textStyle)) {
                i4 = 131072;
                $dirty3 |= i4;
            }
            i4 = 65536;
            $dirty3 |= i4;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changedInstance(label) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        }
        int i12 = i & 1024;
        if (i12 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i13 = i & 2048;
        if (i13 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i14 = i & 4096;
        if (i14 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(keyboardOptions) ? 256 : 128;
        }
        int i15 = i & 8192;
        if (i15 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(keyboardActions) ? 2048 : 1024;
        }
        int i16 = i & 16384;
        if (i16 != 0) {
            $dirty1 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty1 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        int i17 = i & 32768;
        if (i17 != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty1 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i18 = i & 65536;
        if (i18 != 0) {
            $dirty1 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            if ((i & 131072) == 0 && $composer3.changed(shape)) {
                i3 = 8388608;
                $dirty1 |= i3;
            }
            i3 = 4194304;
            $dirty1 |= i3;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0 && $composer3.changed(colors)) {
                i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty1 |= i2;
            }
            i2 = 33554432;
            $dirty1 |= i2;
        }
        if (($dirty3 & 1533916891) == 306783378 && (191739611 & $dirty1) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            colors2 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i6 != 0 ? true : enabled;
                boolean readOnly3 = i7 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    modifier2 = modifier4;
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) consume;
                    $dirty3 &= -458753;
                } else {
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i8 != 0 ? null : label;
                Function2 placeholder3 = i9 != 0 ? null : placeholder;
                Function2 leadingIcon3 = i10 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i11 != 0 ? null : trailingIcon;
                boolean isError3 = i12 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i13 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i14 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i15 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine3 = i16 != 0 ? false : singleLine;
                int maxLines4 = i17 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i18 != 0) {
                    $dirty = $dirty3;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    textStyle3 = textStyle2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty3;
                    textStyle3 = textStyle2;
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty1 &= -29360129;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((262144 & i) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    colors2 = TextFieldDefaults.INSTANCE.m1241outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    placeholder2 = placeholder3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    label2 = label3;
                    singleLine2 = singleLine3;
                    maxLines2 = maxLines4;
                    readOnly2 = readOnly3;
                    $dirty2 = $dirty;
                    maxLines3 = $dirty1 & (-234881025);
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    colors2 = colors;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    placeholder2 = placeholder3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    label2 = label3;
                    singleLine2 = singleLine3;
                    maxLines2 = maxLines4;
                    readOnly2 = readOnly3;
                    $dirty2 = $dirty;
                    maxLines3 = $dirty1;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 131072) != 0) {
                    $dirty1 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    modifier3 = modifier;
                    enabled3 = enabled;
                    readOnly2 = readOnly;
                    textStyle4 = textStyle;
                    label2 = label;
                    placeholder2 = placeholder;
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    interactionSource4 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty2 = $dirty3;
                    maxLines3 = $dirty1 & (-234881025);
                } else {
                    modifier3 = modifier;
                    enabled3 = enabled;
                    readOnly2 = readOnly;
                    textStyle4 = textStyle;
                    label2 = label;
                    placeholder2 = placeholder;
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    interactionSource4 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty2 = $dirty3;
                    maxLines3 = $dirty1;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099955827, $dirty2, maxLines3, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:223)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, 1, interactionSource4, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | ($dirty2 & 458752) | ($dirty2 & 3670016) | ($dirty2 & 29360128) | ($dirty2 & 234881024) | (1879048192 & $dirty2), (maxLines3 & 14) | 1572864 | (maxLines3 & 112) | (maxLines3 & 896) | (maxLines3 & 7168) | (maxLines3 & 57344) | (maxLines3 & 458752) | ((maxLines3 << 3) & 29360128) | ((maxLines3 << 3) & 234881024) | ((maxLines3 << 3) & 1879048192), 0);
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
        final TextStyle textStyle5 = textStyle4;
        final Function2 function2 = label2;
        final Function2 function22 = placeholder2;
        final Function2 function23 = leadingIcon2;
        final Function2 function24 = trailingIcon2;
        final boolean z3 = isError2;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z4 = singleLine2;
        final int i19 = maxLines2;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Shape shape4 = shape3;
        final TextFieldColors textFieldColors = colors2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6
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

            public final void invoke(Composer composer, int i20) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, z, z2, textStyle5, function2, function22, function23, function24, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i19, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x01d7, code lost:
    
        if (r7.changed(r84) != false) goto L152;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r71, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94) {
        /*
            Method dump skipped, instructions count: 1809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x01d3, code lost:
    
        if (r10.changed(r85) != false) goto L152;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r72, final kotlin.jvm.functions.Function1 r73, androidx.compose.ui.Modifier r74, boolean r75, boolean r76, androidx.compose.ui.text.TextStyle r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, kotlin.jvm.functions.Function2 r81, boolean r82, androidx.compose.ui.text.input.VisualTransformation r83, androidx.compose.foundation.text.KeyboardOptions r84, androidx.compose.foundation.text.KeyboardActions r85, boolean r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94) {
        /*
            Method dump skipped, instructions count: 1492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x08ae  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x06c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextFieldLayout(final androidx.compose.ui.Modifier r53, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, final boolean r59, final float r60, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Size, kotlin.Unit> r61, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, final androidx.compose.foundation.layout.PaddingValues r63, androidx.compose.runtime.Composer r64, final int r65, final int r66) {
        /*
            Method dump skipped, instructions count: 2282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m1146calculateWidthO3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int middleSection = Math.max(textFieldPlaceableWidth, Math.max(MathHelpersKt.lerp(labelPlaceableWidth, 0, animationProgress), placeholderPlaceableWidth));
        int wrappedWidth = leadingPlaceableWidth + middleSection + trailingPlaceableWidth;
        float arg0$iv = paddingValues.mo435calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
        float other$iv = paddingValues.mo436calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
        float labelHorizontalPadding = Dp.m5218constructorimpl(arg0$iv + other$iv) * density;
        int focusedLabelWidth = MathKt.roundToInt((labelPlaceableWidth + labelHorizontalPadding) * animationProgress);
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m5176getMinWidthimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1145calculateHeightO3s9Psw(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int inputFieldHeight = Math.max(textFieldPlaceableHeight, Math.max(placeholderPlaceableHeight, MathHelpersKt.lerp(labelPlaceableHeight, 0, animationProgress)));
        float topPadding = paddingValues.getTop() * density;
        float actualTopPadding = MathHelpersKt.lerp(topPadding, Math.max(topPadding, labelPlaceableHeight / 2.0f), animationProgress);
        float bottomPadding = paddingValues.getBottom() * density;
        float middleSectionHeight = inputFieldHeight + actualTopPadding + bottomPadding;
        return Math.max(Constraints.m5175getMinHeightimpl(constraints), Math.max(leadingPlaceableHeight, Math.max(trailingPlaceableHeight, MathKt.roundToInt(middleSectionHeight))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int height, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable borderPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int i;
        int i2;
        int i3;
        float widthOrZero;
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
                i3 = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                i3 = topPadding;
            }
            int startPositionY = i3;
            int positionY = MathHelpersKt.lerp(startPositionY, -(labelPlaceable.getHeight() / 2), animationProgress);
            if (leadingPlaceable == null) {
                widthOrZero = 0.0f;
            } else {
                widthOrZero = (TextFieldImplKt.widthOrZero(leadingPlaceable) - iconPadding) * (1 - animationProgress);
            }
            int positionX = MathKt.roundToInt(widthOrZero) + startPadding;
            Placeable.PlacementScope.placeRelative$default($this$place, labelPlaceable, positionX, positionY, 0.0f, 4, null);
        }
        if (singleLine) {
            i = Alignment.INSTANCE.getCenterVertically().align(textFieldPlaceable.getHeight(), height);
        } else {
            i = topPadding;
        }
        int textVerticalPosition = Math.max(i, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            if (singleLine) {
                i2 = Alignment.INSTANCE.getCenterVertically().align(placeholderPlaceable.getHeight(), height);
            } else {
                i2 = topPadding;
            }
            int placeholderVerticalPosition = Math.max(i2, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
            Placeable.PlacementScope.placeRelative$default($this$place, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, null);
        }
        Placeable.PlacementScope.m4243place70tqf50$default($this$place, borderPlaceable, IntOffset.INSTANCE.m5346getZeronOccac(), 0.0f, 2, null);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1147outlineCutout12SF9DM(Modifier outlineCutout, final long labelSize, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

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
