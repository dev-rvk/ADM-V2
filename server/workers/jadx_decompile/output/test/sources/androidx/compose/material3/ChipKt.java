package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a¦\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a¼\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0097\u0001\u0010(\u001a\u00020\b2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0001H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a¦\u0001\u0010.\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a®\u0001\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00104\u001a\u008f\u0001\u00105\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00107\u001a®\u0001\u00108\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00104\u001aÅ\u0001\u00109\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010:\u001aÑ\u0001\u0010;\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u0002012\b\u0010\u0017\u001a\u0004\u0018\u0001022\b\u0010\u0019\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u008f\u0001\u0010>\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00107\u001a&\u0010?\u001a\u00020\u00012\b\b\u0002\u0010@\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020\u00102\b\b\u0002\u0010B\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SuggestionChipPadding", "AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ChipColors;", "elevation", "Landroidx/compose/material3/ChipElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/material3/ChipBorder;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/foundation/BorderStroke;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "Landroidx/compose/material3/SelectableChipBorder;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/material3/SelectableChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/material3/SelectableChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final float HorizontalElementsPadding = Dp.m5218constructorimpl(8);
    private static final PaddingValues AssistChipPadding = PaddingKt.m479PaddingValuesYgX7TsA$default(HorizontalElementsPadding, 0.0f, 2, null);
    private static final PaddingValues FilterChipPadding = PaddingKt.m479PaddingValuesYgX7TsA$default(HorizontalElementsPadding, 0.0f, 2, null);
    private static final PaddingValues SuggestionChipPadding = PaddingKt.m479PaddingValuesYgX7TsA$default(HorizontalElementsPadding, 0.0f, 2, null);

    public static final void AssistChip(final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Function2 leadingIcon;
        ChipColors chipColors;
        int i2;
        MutableInteractionSource mutableInteractionSource;
        Function2 trailingIcon;
        Shape shape2;
        ChipColors colors2;
        ChipElevation elevation2;
        int $dirty;
        int $dirty1;
        int i3;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        Modifier modifier3;
        ChipBorder border3;
        Function2 leadingIcon2;
        ChipElevation elevation3;
        int $dirty2;
        ChipColors colors3;
        boolean enabled2;
        Object value$iv$iv;
        int $dirty12;
        Composer $composer2;
        ChipBorder border4;
        ChipColors colors4;
        boolean enabled3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer3 = $composer.startRestartGroup(-1932300596);
        ComposerKt.sourceInformation($composer3, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)110@5623L5,111@5674L18,112@5745L21,113@5813L18,114@5883L39,120@6059L10,121@6137L19,115@5928L543:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(onClick) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(label) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty3 |= 24576;
            leadingIcon = function2;
        } else if (($changed & 57344) == 0) {
            leadingIcon = function2;
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? 16384 : 8192;
        } else {
            leadingIcon = function2;
        }
        int i11 = i & 32;
        if (i11 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changedInstance(function22) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(shape)) {
                i7 = 1048576;
                $dirty3 |= i7;
            }
            i7 = 524288;
            $dirty3 |= i7;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                chipColors = colors;
                if ($composer3.changed(chipColors)) {
                    i6 = 8388608;
                    $dirty3 |= i6;
                }
            } else {
                chipColors = colors;
            }
            i6 = 4194304;
            $dirty3 |= i6;
        } else {
            chipColors = colors;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer3.changed(elevation)) {
                i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty3 |= i5;
            }
            i5 = 33554432;
            $dirty3 |= i5;
        }
        if (($changed & 1879048192) == 0) {
            if ((i & 512) == 0 && $composer3.changed(border)) {
                i4 = 536870912;
                $dirty3 |= i4;
            }
            i4 = 268435456;
            $dirty3 |= i4;
        }
        int i12 = i & 1024;
        if (i12 != 0) {
            $dirty13 |= 6;
            i2 = i12;
            mutableInteractionSource = interactionSource;
        } else if (($changed1 & 14) == 0) {
            i2 = i12;
            mutableInteractionSource = interactionSource;
            $dirty13 |= $composer3.changed(mutableInteractionSource) ? 4 : 2;
        } else {
            i2 = i12;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty13 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled3 = enabled;
            trailingIcon = function22;
            shape2 = shape;
            elevation3 = elevation;
            border4 = border;
            colors4 = chipColors;
            modifier3 = modifier2;
            interactionSource2 = mutableInteractionSource;
            leadingIcon2 = leadingIcon;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i9 != 0 ? true : enabled;
                if (i10 != 0) {
                    leadingIcon = null;
                }
                trailingIcon = i11 != 0 ? null : function22;
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                    shape2 = AssistChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape2 = shape;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                    colors2 = AssistChipDefaults.INSTANCE.m1304assistChipColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 100663296, 255);
                } else {
                    colors2 = chipColors;
                }
                if ((i & 256) != 0) {
                    $dirty = $dirty3 & (-234881025);
                    elevation2 = AssistChipDefaults.INSTANCE.m1305assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    elevation2 = elevation;
                    $dirty = $dirty3;
                }
                if ((i & 512) != 0) {
                    $dirty1 = $dirty13;
                    i3 = i2;
                    border2 = AssistChipDefaults.INSTANCE.m1303assistChipBorderd_3_b6Q(0L, 0L, 0.0f, $composer3, 3072, 7);
                    $dirty &= -1879048193;
                } else {
                    $dirty1 = $dirty13;
                    i3 = i2;
                    border2 = border;
                }
                if (i3 != 0) {
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
                    modifier3 = modifier4;
                    border3 = border2;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    leadingIcon2 = leadingIcon;
                    elevation3 = elevation2;
                    $dirty2 = $dirty;
                    colors3 = colors2;
                    enabled2 = enabled4;
                } else {
                    interactionSource2 = interactionSource;
                    modifier3 = modifier4;
                    border3 = border2;
                    leadingIcon2 = leadingIcon;
                    elevation3 = elevation2;
                    $dirty2 = $dirty;
                    colors3 = colors2;
                    enabled2 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((i & 512) != 0) {
                    enabled2 = enabled;
                    trailingIcon = function22;
                    shape2 = shape;
                    elevation3 = elevation;
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty1 = $dirty13;
                    colors3 = chipColors;
                    modifier3 = modifier2;
                    leadingIcon2 = leadingIcon;
                    $dirty2 = (-1879048193) & $dirty3;
                } else {
                    enabled2 = enabled;
                    trailingIcon = function22;
                    shape2 = shape;
                    elevation3 = elevation;
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty1 = $dirty13;
                    colors3 = chipColors;
                    modifier3 = modifier2;
                    leadingIcon2 = leadingIcon;
                    $dirty2 = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                $dirty12 = $dirty1;
                ComposerKt.traceEventStart(-1932300596, $dirty2, $dirty12, "androidx.compose.material3.AssistChip (Chip.kt:103)");
            } else {
                $dirty12 = $dirty1;
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
            long m2959unboximpl = colors3.labelColor$material3_release(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 18) & 112)).getValue().m2959unboximpl();
            $composer3.startReplaceableGroup(839902004);
            ComposerKt.sourceInformation($composer3, "127@6316L21");
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 24) & 112));
            $composer3.endReplaceableGroup();
            $composer2 = $composer3;
            border4 = border3;
            colors4 = colors3;
            enabled3 = enabled2;
            m1345ChipnkUnTEs(modifier3, onClick, enabled2, label, fromToken, m2959unboximpl, leadingIcon2, trailingIcon, shape2, colors4, elevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m1308getHeightD9Ej5fM(), AssistChipPadding, interactionSource2, $composer2, (($dirty2 >> 6) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty2 << 6) & 7168) | (($dirty2 << 6) & 3670016) | (($dirty2 << 6) & 29360128) | (($dirty2 << 6) & 234881024) | (($dirty2 << 6) & 1879048192), (($dirty2 >> 24) & 14) | 3456 | (($dirty12 << 12) & 57344));
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
        final Function2 function23 = leadingIcon2;
        final Function2 function24 = trailingIcon;
        final Shape shape3 = shape2;
        final ChipColors chipColors2 = colors4;
        final ChipElevation chipElevation = elevation3;
        final ChipBorder chipBorder = border4;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AssistChip$2
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

            public final void invoke(Composer composer, int i13) {
                ChipKt.AssistChip(onClick, label, modifier5, z, function23, function24, shape3, chipColors2, chipElevation, chipBorder, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void ElevatedAssistChip(final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean z;
        ChipColors chipColors;
        int i2;
        int i3;
        MutableInteractionSource mutableInteractionSource;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Shape shape2;
        int $dirty;
        ChipColors colors2;
        Modifier modifier3;
        int $dirty1;
        int i4;
        int i5;
        int i6;
        ChipElevation elevation2;
        Modifier modifier4;
        MutableInteractionSource interactionSource2;
        ChipElevation elevation3;
        ChipBorder border2;
        ChipColors colors3;
        int $dirty2;
        boolean enabled2;
        Object value$iv$iv;
        int $dirty12;
        ChipBorder border3;
        ChipColors colors4;
        boolean enabled3;
        Composer $composer2;
        int i7;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer3 = $composer.startRestartGroup(1295844802);
        ComposerKt.sourceInformation($composer3, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)181@9326L5,182@9377L26,183@9456L29,185@9569L39,191@9744L10,192@9822L19,186@9613L543:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(onClick) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(label) ? 32 : 16;
        }
        int i10 = i & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i11 = i & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty3 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        int i13 = i & 32;
        if (i13 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changedInstance(function22) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(shape)) {
                i9 = 1048576;
                $dirty3 |= i9;
            }
            i9 = 524288;
            $dirty3 |= i9;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                chipColors = colors;
                if ($composer3.changed(chipColors)) {
                    i8 = 8388608;
                    $dirty3 |= i8;
                }
            } else {
                chipColors = colors;
            }
            i8 = 4194304;
            $dirty3 |= i8;
        } else {
            chipColors = colors;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer3.changed(elevation)) {
                i7 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty3 |= i7;
            }
            i7 = 33554432;
            $dirty3 |= i7;
        }
        int i14 = i & 512;
        if (i14 != 0) {
            $dirty3 |= 805306368;
            i2 = i14;
        } else if (($changed & 1879048192) == 0) {
            i2 = i14;
            $dirty3 |= $composer3.changed(border) ? 536870912 : 268435456;
        } else {
            i2 = i14;
        }
        int i15 = i & 1024;
        if (i15 != 0) {
            $dirty13 |= 6;
            i3 = i15;
            mutableInteractionSource = interactionSource;
        } else if (($changed1 & 14) == 0) {
            i3 = i15;
            mutableInteractionSource = interactionSource;
            $dirty13 |= $composer3.changed(mutableInteractionSource) ? 4 : 2;
        } else {
            i3 = i15;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty13 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon = function2;
            trailingIcon = function22;
            shape2 = shape;
            elevation3 = elevation;
            border3 = border;
            colors4 = chipColors;
            modifier4 = modifier2;
            enabled3 = z;
            interactionSource2 = mutableInteractionSource;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i11 != 0 ? true : z;
                leadingIcon = i12 != 0 ? null : function2;
                trailingIcon = i13 != 0 ? null : function22;
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                    shape2 = AssistChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape2 = shape;
                }
                if ((i & 128) != 0) {
                    $dirty = $dirty3 & (-29360129);
                    colors2 = AssistChipDefaults.INSTANCE.m1306elevatedAssistChipColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 100663296, 255);
                } else {
                    $dirty = $dirty3;
                    colors2 = chipColors;
                }
                if ((i & 256) != 0) {
                    $dirty1 = $dirty13;
                    modifier3 = modifier5;
                    i4 = 6;
                    i5 = i2;
                    i6 = i3;
                    elevation2 = AssistChipDefaults.INSTANCE.m1307elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty &= -234881025;
                } else {
                    modifier3 = modifier5;
                    $dirty1 = $dirty13;
                    i4 = 6;
                    i5 = i2;
                    i6 = i3;
                    elevation2 = elevation;
                }
                ChipBorder border4 = i5 != 0 ? null : border;
                if (i6 != 0) {
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
                    modifier4 = modifier3;
                    elevation3 = elevation2;
                    border2 = border4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    colors3 = colors2;
                    $dirty2 = $dirty;
                    enabled2 = enabled4;
                } else {
                    modifier4 = modifier3;
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    border2 = border4;
                    colors3 = colors2;
                    $dirty2 = $dirty;
                    enabled2 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    leadingIcon = function2;
                    trailingIcon = function22;
                    shape2 = shape;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = (-234881025) & $dirty3;
                    $dirty1 = $dirty13;
                    colors3 = chipColors;
                    modifier4 = modifier2;
                    i4 = 6;
                    enabled2 = z;
                    border2 = border;
                } else {
                    leadingIcon = function2;
                    trailingIcon = function22;
                    shape2 = shape;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty3;
                    $dirty1 = $dirty13;
                    colors3 = chipColors;
                    modifier4 = modifier2;
                    i4 = 6;
                    enabled2 = z;
                    border2 = border;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                $dirty12 = $dirty1;
                ComposerKt.traceEventStart(1295844802, $dirty2, $dirty12, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:174)");
            } else {
                $dirty12 = $dirty1;
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i4), AssistChipTokens.INSTANCE.getLabelTextFont());
            long m2959unboximpl = colors3.labelColor$material3_release(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 18) & 112)).getValue().m2959unboximpl();
            float m1308getHeightD9Ej5fM = AssistChipDefaults.INSTANCE.m1308getHeightD9Ej5fM();
            PaddingValues paddingValues = AssistChipPadding;
            $composer3.startReplaceableGroup(-227039519);
            ComposerKt.sourceInformation($composer3, "200@10083L21");
            State<BorderStroke> borderStroke$material3_release = border2 == null ? null : border2.borderStroke$material3_release(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 24) & 112));
            $composer3.endReplaceableGroup();
            border3 = border2;
            colors4 = colors3;
            enabled3 = enabled2;
            $composer2 = $composer3;
            m1345ChipnkUnTEs(modifier4, onClick, enabled2, label, fromToken, m2959unboximpl, leadingIcon, trailingIcon, shape2, colors4, elevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m1308getHeightD9Ej5fM, paddingValues, interactionSource2, $composer2, (($dirty2 >> 6) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty2 << 6) & 7168) | (($dirty2 << 6) & 3670016) | (($dirty2 << 6) & 29360128) | (($dirty2 << 6) & 234881024) | (($dirty2 << 6) & 1879048192), (($dirty2 >> 24) & 14) | 3456 | (($dirty12 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z2 = enabled3;
        final Function2 function23 = leadingIcon;
        final Function2 function24 = trailingIcon;
        final Shape shape3 = shape2;
        final ChipColors chipColors2 = colors4;
        final ChipElevation chipElevation = elevation3;
        final ChipBorder chipBorder = border3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedAssistChip$2
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
                ChipKt.ElevatedAssistChip(onClick, label, modifier6, z2, function23, function24, shape3, chipColors2, chipElevation, chipBorder, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void FilterChip(final boolean selected, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, SelectableChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean z;
        Function2 function23;
        Function2 function24;
        int i2;
        MutableInteractionSource mutableInteractionSource;
        int $dirty1;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Shape shape2;
        SelectableChipColors colors2;
        int $dirty;
        int i3;
        Composer $composer2;
        SelectableChipElevation elevation2;
        int $dirty2;
        SelectableChipBorder border2;
        Modifier modifier3;
        MutableInteractionSource interactionSource2;
        SelectableChipElevation elevation3;
        int $dirty3;
        SelectableChipBorder border3;
        int $dirty12;
        boolean enabled2;
        Object value$iv$iv;
        SelectableChipBorder border4;
        boolean enabled3;
        Composer $composer3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer4 = $composer.startRestartGroup(-1878072905);
        ComposerKt.sourceInformation($composer4, "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)263@13479L5,264@13540L18,265@13621L21,266@13699L18,267@13769L39,274@13979L10,268@13813L556:Chip.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer4.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer4.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer4.changedInstance(label) ? 256 : 128;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty4 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 7168) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty4 |= 24576;
            z = enabled;
        } else if (($changed & 57344) == 0) {
            z = enabled;
            $dirty4 |= $composer4.changed(z) ? 16384 : 8192;
        } else {
            z = enabled;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function23 = function2;
        } else if (($changed & 458752) == 0) {
            function23 = function2;
            $dirty4 |= $composer4.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function2;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty4 |= 1572864;
            function24 = function22;
        } else if (($changed & 3670016) == 0) {
            function24 = function22;
            $dirty4 |= $composer4.changedInstance(function24) ? 1048576 : 524288;
        } else {
            function24 = function22;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer4.changed(shape)) {
                i7 = 8388608;
                $dirty4 |= i7;
            }
            i7 = 4194304;
            $dirty4 |= i7;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer4.changed(colors)) {
                i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty4 |= i6;
            }
            i6 = 33554432;
            $dirty4 |= i6;
        }
        if (($changed & 1879048192) == 0) {
            if ((i & 512) == 0 && $composer4.changed(elevation)) {
                i5 = 536870912;
                $dirty4 |= i5;
            }
            i5 = 268435456;
            $dirty4 |= i5;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer4.changed(border)) {
                i4 = 4;
                $dirty13 |= i4;
            }
            i4 = 2;
            $dirty13 |= i4;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 = $dirty13 | 48;
            i2 = i12;
            mutableInteractionSource = interactionSource;
        } else {
            if (($changed1 & 112) == 0) {
                i2 = i12;
                mutableInteractionSource = interactionSource;
                $dirty13 |= $composer4.changed(mutableInteractionSource) ? 32 : 16;
            } else {
                i2 = i12;
                mutableInteractionSource = interactionSource;
            }
            $dirty1 = $dirty13;
        }
        if ((1533916891 & $dirty4) == 306783378 && ($dirty1 & 91) == 18 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            shape2 = shape;
            colors2 = colors;
            elevation3 = elevation;
            border4 = border;
            enabled3 = z;
            leadingIcon = function23;
            trailingIcon = function24;
            interactionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            $composer3 = $composer4;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i9 != 0 ? true : z;
                leadingIcon = i10 != 0 ? null : function23;
                trailingIcon = i11 != 0 ? null : function24;
                if ((i & 128) != 0) {
                    $dirty4 &= -29360129;
                    shape2 = FilterChipDefaults.INSTANCE.getShape($composer4, 6);
                } else {
                    shape2 = shape;
                }
                if ((i & 256) != 0) {
                    $dirty = $dirty4 & (-234881025);
                    colors2 = FilterChipDefaults.INSTANCE.m1529filterChipColorsXqyqHi0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer4, 0, 384, 4095);
                } else {
                    colors2 = colors;
                    $dirty = $dirty4;
                }
                if ((i & 512) != 0) {
                    i3 = i2;
                    $composer2 = $composer4;
                    elevation2 = FilterChipDefaults.INSTANCE.m1530filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer4, 1572864, 63);
                    $dirty2 = $dirty & (-1879048193);
                } else {
                    i3 = i2;
                    $composer2 = $composer4;
                    elevation2 = elevation;
                    $dirty2 = $dirty;
                }
                if ((i & 1024) != 0) {
                    border2 = FilterChipDefaults.INSTANCE.m1528filterChipBordergHcDVlo(0L, 0L, 0L, 0L, 0.0f, 0.0f, $composer2, 1572864, 63);
                    $dirty1 &= -15;
                } else {
                    border2 = border;
                }
                if (i3 != 0) {
                    $composer4 = $composer2;
                    $composer4.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer4, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer4.rememberedValue();
                    Modifier modifier5 = modifier4;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer4.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer4.endReplaceableGroup();
                    modifier3 = modifier5;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    elevation3 = elevation2;
                    $dirty3 = $dirty2;
                    border3 = border2;
                    $dirty12 = $dirty1;
                    enabled2 = enabled4;
                } else {
                    $composer4 = $composer2;
                    modifier3 = modifier4;
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    $dirty3 = $dirty2;
                    border3 = border2;
                    $dirty12 = $dirty1;
                    enabled2 = enabled4;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty4 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty4 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty1 &= -15;
                }
                shape2 = shape;
                colors2 = colors;
                elevation3 = elevation;
                enabled2 = z;
                leadingIcon = function23;
                trailingIcon = function24;
                interactionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                $dirty12 = $dirty1;
                border3 = border;
                $dirty3 = $dirty4;
            }
            $composer4.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1878072905, $dirty3, $dirty12, "androidx.compose.material3.FilterChip (Chip.kt:255)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, 6), FilterChipTokens.INSTANCE.getLabelTextFont());
            float m1531getHeightD9Ej5fM = FilterChipDefaults.INSTANCE.m1531getHeightD9Ej5fM();
            PaddingValues paddingValues = FilterChipPadding;
            $composer4.startReplaceableGroup(276171431);
            ComposerKt.sourceInformation($composer4, "283@14286L31");
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled2, selected, $composer4, (($dirty3 >> 12) & 14) | (($dirty3 << 3) & 112) | (($dirty12 << 6) & 896));
            $composer4.endReplaceableGroup();
            border4 = border3;
            enabled3 = enabled2;
            $composer3 = $composer4;
            m1347SelectableChipu0RnIRE(selected, modifier3, onClick, enabled2, label, fromToken, leadingIcon, null, trailingIcon, shape2, colors2, elevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m1531getHeightD9Ej5fM, paddingValues, interactionSource2, $composer3, ($dirty3 & 14) | 12582912 | (($dirty3 >> 6) & 112) | (($dirty3 << 3) & 896) | (($dirty3 >> 3) & 7168) | (($dirty3 << 6) & 57344) | (($dirty3 << 3) & 3670016) | (($dirty3 << 6) & 234881024) | (($dirty3 << 6) & 1879048192), (($dirty3 >> 24) & 14) | 27648 | (($dirty3 >> 24) & 112) | (($dirty12 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        final boolean z2 = enabled3;
        final Function2 function25 = leadingIcon;
        final Function2 function26 = trailingIcon;
        final Shape shape3 = shape2;
        final SelectableChipColors selectableChipColors = colors2;
        final SelectableChipElevation selectableChipElevation = elevation3;
        final SelectableChipBorder selectableChipBorder = border4;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$FilterChip$2
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

            public final void invoke(Composer composer, int i13) {
                ChipKt.FilterChip(selected, onClick, label, modifier6, z2, function25, function26, shape3, selectableChipColors, selectableChipElevation, selectableChipBorder, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void ElevatedFilterChip(final boolean selected, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, SelectableChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Function2 function23;
        Function2 function24;
        int i2;
        int i3;
        MutableInteractionSource mutableInteractionSource;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Shape shape2;
        SelectableChipColors colors2;
        int $dirty;
        int i4;
        int $dirty1;
        Composer $composer2;
        int i5;
        SelectableChipElevation elevation2;
        MutableInteractionSource interactionSource2;
        Modifier modifier3;
        SelectableChipElevation elevation3;
        SelectableChipBorder border2;
        SelectableChipColors colors3;
        int $dirty2;
        boolean enabled2;
        Object value$iv$iv;
        int $dirty12;
        SelectableChipBorder border3;
        boolean enabled3;
        Composer $composer3;
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer4 = $composer.startRestartGroup(1904578605);
        ComposerKt.sourceInformation($composer4, "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)343@17577L5,344@17638L26,345@17727L29,347@17850L39,354@18060L10,348@17894L556:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer4.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer4.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer4.changedInstance(label) ? 256 : 128;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty3 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 7168) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer4.changed(enabled) ? 16384 : 8192;
        }
        int i11 = i & 32;
        if (i11 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function23 = function2;
        } else if (($changed & 458752) == 0) {
            function23 = function2;
            $dirty3 |= $composer4.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function2;
        }
        int i12 = i & 64;
        if (i12 != 0) {
            $dirty3 |= 1572864;
            function24 = function22;
        } else if (($changed & 3670016) == 0) {
            function24 = function22;
            $dirty3 |= $composer4.changedInstance(function24) ? 1048576 : 524288;
        } else {
            function24 = function22;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer4.changed(shape)) {
                i8 = 8388608;
                $dirty3 |= i8;
            }
            i8 = 4194304;
            $dirty3 |= i8;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer4.changed(colors)) {
                i7 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty3 |= i7;
            }
            i7 = 33554432;
            $dirty3 |= i7;
        }
        if (($changed & 1879048192) == 0) {
            if ((i & 512) == 0 && $composer4.changed(elevation)) {
                i6 = 536870912;
                $dirty3 |= i6;
            }
            i6 = 268435456;
            $dirty3 |= i6;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty13 |= 6;
            i2 = i13;
        } else if (($changed1 & 14) == 0) {
            i2 = i13;
            $dirty13 |= $composer4.changed(border) ? 4 : 2;
        } else {
            i2 = i13;
        }
        int i14 = i & 2048;
        if (i14 != 0) {
            $dirty13 |= 48;
            i3 = i14;
            mutableInteractionSource = interactionSource;
        } else if (($changed1 & 112) == 0) {
            i3 = i14;
            mutableInteractionSource = interactionSource;
            $dirty13 |= $composer4.changed(mutableInteractionSource) ? 32 : 16;
        } else {
            i3 = i14;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty13 & 91) == 18 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            enabled3 = enabled;
            shape2 = shape;
            colors3 = colors;
            elevation3 = elevation;
            border3 = border;
            leadingIcon = function23;
            trailingIcon = function24;
            interactionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            $composer3 = $composer4;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i10 != 0 ? true : enabled;
                leadingIcon = i11 != 0 ? null : function23;
                trailingIcon = i12 != 0 ? null : function24;
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                    shape2 = FilterChipDefaults.INSTANCE.getShape($composer4, 6);
                } else {
                    shape2 = shape;
                }
                if ((i & 256) != 0) {
                    $dirty = $dirty3 & (-234881025);
                    colors2 = FilterChipDefaults.INSTANCE.m1526elevatedFilterChipColorsXqyqHi0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer4, 0, 384, 4095);
                } else {
                    colors2 = colors;
                    $dirty = $dirty3;
                }
                if ((i & 512) != 0) {
                    $dirty1 = $dirty13;
                    i4 = i3;
                    i5 = i2;
                    $composer2 = $composer4;
                    elevation2 = FilterChipDefaults.INSTANCE.m1527elevatedFilterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer4, 1572864, 63);
                    $dirty &= -1879048193;
                } else {
                    i4 = i3;
                    $dirty1 = $dirty13;
                    $composer2 = $composer4;
                    i5 = i2;
                    elevation2 = elevation;
                }
                SelectableChipBorder border4 = i5 != 0 ? null : border;
                if (i4 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    modifier3 = modifier4;
                    elevation3 = elevation2;
                    border2 = border4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    colors3 = colors2;
                    $dirty2 = $dirty;
                    enabled2 = enabled4;
                } else {
                    interactionSource2 = interactionSource;
                    modifier3 = modifier4;
                    elevation3 = elevation2;
                    border2 = border4;
                    colors3 = colors2;
                    $dirty2 = $dirty;
                    enabled2 = enabled4;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((i & 512) != 0) {
                    shape2 = shape;
                    colors3 = colors;
                    elevation3 = elevation;
                    border2 = border;
                    $dirty1 = $dirty13;
                    leadingIcon = function23;
                    trailingIcon = function24;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    $composer2 = $composer4;
                    enabled2 = enabled;
                    $dirty2 = (-1879048193) & $dirty3;
                } else {
                    shape2 = shape;
                    colors3 = colors;
                    elevation3 = elevation;
                    border2 = border;
                    $dirty1 = $dirty13;
                    leadingIcon = function23;
                    trailingIcon = function24;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    $composer2 = $composer4;
                    enabled2 = enabled;
                    $dirty2 = $dirty3;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                $dirty12 = $dirty1;
                ComposerKt.traceEventStart(1904578605, $dirty2, $dirty12, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:335)");
            } else {
                $dirty12 = $dirty1;
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), FilterChipTokens.INSTANCE.getLabelTextFont());
            float m1531getHeightD9Ej5fM = FilterChipDefaults.INSTANCE.m1531getHeightD9Ej5fM();
            PaddingValues paddingValues = FilterChipPadding;
            $composer2.startReplaceableGroup(-790769778);
            ComposerKt.sourceInformation($composer2, "363@18367L31");
            State<BorderStroke> borderStroke$material3_release = border2 == null ? null : border2.borderStroke$material3_release(enabled2, selected, $composer2, (($dirty2 >> 12) & 14) | (($dirty2 << 3) & 112) | (($dirty12 << 6) & 896));
            $composer2.endReplaceableGroup();
            border3 = border2;
            enabled3 = enabled2;
            $composer3 = $composer2;
            m1347SelectableChipu0RnIRE(selected, modifier3, onClick, enabled2, label, fromToken, leadingIcon, null, trailingIcon, shape2, colors3, elevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m1531getHeightD9Ej5fM, paddingValues, interactionSource2, $composer3, ($dirty2 & 14) | 12582912 | (($dirty2 >> 6) & 112) | (($dirty2 << 3) & 896) | (($dirty2 >> 3) & 7168) | (($dirty2 << 6) & 57344) | (($dirty2 << 3) & 3670016) | (($dirty2 << 6) & 234881024) | (($dirty2 << 6) & 1879048192), (($dirty2 >> 24) & 14) | 27648 | (($dirty2 >> 24) & 112) | (($dirty12 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z = enabled3;
        final Function2 function25 = leadingIcon;
        final Function2 function26 = trailingIcon;
        final Shape shape3 = shape2;
        final SelectableChipColors selectableChipColors = colors3;
        final SelectableChipElevation selectableChipElevation = elevation3;
        final SelectableChipBorder selectableChipBorder = border3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedFilterChip$2
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

            public final void invoke(Composer composer, int i15) {
                ChipKt.ElevatedFilterChip(selected, onClick, label, modifier5, z, function25, function26, shape3, selectableChipColors, selectableChipElevation, selectableChipBorder, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void InputChip(final boolean selected, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, SelectableChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2 leadingIcon;
        Function2 avatar;
        Modifier modifier2;
        Shape shape2;
        SelectableChipColors colors2;
        SelectableChipElevation elevation2;
        SelectableChipBorder border2;
        Modifier modifier3;
        SelectableChipElevation elevation3;
        MutableInteractionSource interactionSource2;
        SelectableChipColors colors3;
        Shape shape3;
        Function2 leadingIcon2;
        final Function2 leadingIcon3;
        Function2 trailingIcon;
        SelectableChipBorder border3;
        int $dirty1;
        boolean enabled2;
        final int $dirty;
        Object value$iv$iv;
        boolean z;
        Function2 shapedAvatar;
        SelectableChipBorder border4;
        Function2 avatar2;
        boolean enabled3;
        Composer $composer2;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer3 = $composer.startRestartGroup(-1599030387);
        ComposerKt.sourceInformation($composer3, "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)428@21836L5,429@21896L17,430@21975L20,431@22051L17,432@22120L39,459@23091L10,453@22901L787:Chip.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changedInstance(label) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            leadingIcon = function2;
        } else if (($changed & 458752) == 0) {
            leadingIcon = function2;
            $dirty2 |= $composer3.changedInstance(leadingIcon) ? 131072 : 65536;
        } else {
            leadingIcon = function2;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
            avatar = function22;
        } else if (($changed & 3670016) == 0) {
            avatar = function22;
            $dirty2 |= $composer3.changedInstance(avatar) ? 1048576 : 524288;
        } else {
            avatar = function22;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer3.changedInstance(function23) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer3.changed(shape)) {
                i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty2 |= i5;
            }
            i5 = 33554432;
            $dirty2 |= i5;
        }
        if (($changed & 1879048192) == 0) {
            if ((i & 512) == 0 && $composer3.changed(colors)) {
                i4 = 536870912;
                $dirty2 |= i4;
            }
            i4 = 268435456;
            $dirty2 |= i4;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer3.changed(elevation)) {
                i3 = 4;
                $dirty12 |= i3;
            }
            i3 = 2;
            $dirty12 |= i3;
        }
        if (($changed1 & 112) == 0) {
            if ((i & 2048) == 0 && $composer3.changed(border)) {
                i2 = 32;
                $dirty12 |= i2;
            }
            i2 = 16;
            $dirty12 |= i2;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer3.changed(interactionSource) ? 256 : 128;
        }
        if (($dirty2 & 1533916891) == 306783378 && ($dirty12 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            trailingIcon = function23;
            shape3 = shape;
            colors3 = colors;
            elevation3 = elevation;
            border4 = border;
            interactionSource2 = interactionSource;
            leadingIcon2 = leadingIcon;
            avatar2 = avatar;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i6 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i7 != 0 ? true : enabled;
                if (i8 != 0) {
                    leadingIcon = null;
                }
                if (i9 != 0) {
                    avatar = null;
                }
                Function2 trailingIcon2 = i10 != 0 ? null : function23;
                if ((i & 256) != 0) {
                    modifier2 = modifier4;
                    shape2 = InputChipDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty2 &= -234881025;
                } else {
                    modifier2 = modifier4;
                    shape2 = shape;
                }
                if ((i & 512) != 0) {
                    colors2 = InputChipDefaults.INSTANCE.m1562inputChipColorskwJvTHA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 3072, 8191);
                    $dirty2 &= -1879048193;
                } else {
                    colors2 = colors;
                }
                int $dirty3 = $dirty2;
                if ((i & 1024) != 0) {
                    elevation2 = InputChipDefaults.INSTANCE.m1563inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty12 &= -15;
                } else {
                    elevation2 = elevation;
                }
                SelectableChipElevation elevation4 = elevation2;
                if ((i & 2048) != 0) {
                    border2 = InputChipDefaults.INSTANCE.m1561inputChipBordergHcDVlo(0L, 0L, 0L, 0L, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty12 &= -113;
                } else {
                    border2 = border;
                }
                if (i11 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    SelectableChipBorder border5 = border2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier3 = modifier2;
                    elevation3 = elevation4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    colors3 = colors2;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon;
                    leadingIcon3 = avatar;
                    trailingIcon = trailingIcon2;
                    border3 = border5;
                    $dirty1 = $dirty12;
                    enabled2 = enabled4;
                    $dirty = $dirty3;
                } else {
                    modifier3 = modifier2;
                    elevation3 = elevation4;
                    interactionSource2 = interactionSource;
                    colors3 = colors2;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon;
                    leadingIcon3 = avatar;
                    trailingIcon = trailingIcon2;
                    border3 = border2;
                    $dirty1 = $dirty12;
                    enabled2 = enabled4;
                    $dirty = $dirty3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty2 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty12 &= -15;
                }
                if ((i & 2048) != 0) {
                    modifier3 = modifier;
                    trailingIcon = function23;
                    shape3 = shape;
                    colors3 = colors;
                    elevation3 = elevation;
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty1 = $dirty12 & (-113);
                    $dirty = $dirty2;
                    leadingIcon2 = leadingIcon;
                    leadingIcon3 = avatar;
                    enabled2 = enabled;
                } else {
                    modifier3 = modifier;
                    trailingIcon = function23;
                    shape3 = shape;
                    colors3 = colors;
                    elevation3 = elevation;
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    leadingIcon2 = leadingIcon;
                    leadingIcon3 = avatar;
                    enabled2 = enabled;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1599030387, $dirty, $dirty1, "androidx.compose.material3.InputChip (Chip.kt:419)");
            }
            $composer3.startReplaceableGroup(-1372002056);
            ComposerKt.sourceInformation($composer3, "439@22510L9");
            if (leadingIcon3 != null) {
                final float avatarOpacity = enabled2 ? 1.0f : 0.38f;
                final Shape avatarShape = ShapesKt.toShape(InputChipTokens.INSTANCE.getAvatarShape(), $composer3, 6);
                Function2<Composer, Integer, Unit> function24 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$2
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

                    public final void invoke(Composer $composer4, int $changed2) {
                        Object value$iv$iv2;
                        ComposerKt.sourceInformation($composer4, "C442@22624L148,441@22569L311:Chip.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-352359235, $changed2, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:440)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Object key1$iv = Float.valueOf(avatarOpacity);
                            Object key2$iv = avatarShape;
                            final float f = avatarOpacity;
                            final Shape shape4 = avatarShape;
                            $composer4.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation($composer4, "CC(remember)P(1,2):Composables.kt#9igjgp");
                            boolean invalid$iv$iv = $composer4.changed(key1$iv) | $composer4.changed(key2$iv);
                            Object it$iv$iv2 = $composer4.rememberedValue();
                            if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv$iv2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$2$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                        invoke2(graphicsLayerScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                                        graphicsLayer.setAlpha(f);
                                        graphicsLayer.setShape(shape4);
                                        graphicsLayer.setClip(true);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv$iv2);
                            } else {
                                value$iv$iv2 = it$iv$iv2;
                            }
                            $composer4.endReplaceableGroup();
                            Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) value$iv$iv2);
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function25 = leadingIcon3;
                            int i12 = $dirty;
                            $composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                            int $changed$iv$iv = (48 << 3) & 112;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume = $composer4.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            Density density$iv$iv = (Density) consume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume2 = $composer4.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume3 = $composer4.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(factory$iv$iv$iv);
                            } else {
                                $composer4.useNode();
                            }
                            $composer4.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer4);
                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            $composer4.enableReusing();
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                            $composer4.startReplaceableGroup(2058660585);
                            int i13 = ($changed$iv$iv$iv >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i14 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1294414151, "C449@22858L8:Chip.kt#uh7d8r");
                            function25.invoke($composer4, Integer.valueOf((i12 >> 18) & 14));
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceableGroup();
                            $composer4.endNode();
                            $composer4.endReplaceableGroup();
                            $composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                };
                z = true;
                shapedAvatar = ComposableLambdaKt.composableLambda($composer3, -352359235, true, function24);
            } else {
                z = true;
                shapedAvatar = null;
            }
            $composer3.endReplaceableGroup();
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), InputChipTokens.INSTANCE.getLabelTextFont());
            $composer3.startReplaceableGroup(-1372001052);
            ComposerKt.sourceInformation($composer3, "466@23351L31");
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled2, selected, $composer3, (($dirty >> 12) & 14) | (($dirty << 3) & 112) | (($dirty1 << 3) & 896));
            $composer3.endReplaceableGroup();
            border4 = border3;
            avatar2 = leadingIcon3;
            Function2 avatar3 = leadingIcon2;
            enabled3 = enabled2;
            $composer2 = $composer3;
            m1347SelectableChipu0RnIRE(selected, modifier3, onClick, enabled2, label, fromToken, avatar3, shapedAvatar, trailingIcon, shape3, colors3, elevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, InputChipDefaults.INSTANCE.m1559getHeightD9Ej5fM(), inputChipPadding(shapedAvatar != null ? z : false, leadingIcon2 != null ? z : false, trailingIcon != null ? z : false), interactionSource2, $composer2, ($dirty & 14) | (($dirty >> 6) & 112) | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty << 6) & 57344) | (($dirty << 3) & 3670016) | (($dirty << 3) & 234881024) | (($dirty << 3) & 1879048192), (($dirty >> 27) & 14) | 3072 | (($dirty1 << 3) & 112) | (($dirty1 << 9) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z2 = enabled3;
        final Function2 function25 = leadingIcon2;
        final Function2 function26 = avatar2;
        final Function2 function27 = trailingIcon;
        final Shape shape4 = shape3;
        final SelectableChipColors selectableChipColors = colors3;
        final SelectableChipElevation selectableChipElevation = elevation3;
        final SelectableChipBorder selectableChipBorder = border4;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$3
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

            public final void invoke(Composer composer, int i12) {
                ChipKt.InputChip(selected, onClick, label, modifier5, z2, function25, function26, function27, shape4, selectableChipColors, selectableChipElevation, selectableChipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void SuggestionChip(final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function2 function22;
        Shape shape2;
        ChipElevation elevation2;
        int i2;
        MutableInteractionSource mutableInteractionSource;
        Function2 icon;
        Shape shape3;
        ChipColors colors2;
        int $dirty;
        int i3;
        Modifier modifier2;
        int i4;
        ChipBorder border2;
        Modifier modifier3;
        MutableInteractionSource interactionSource2;
        ChipBorder border3;
        ChipElevation elevation3;
        int $dirty2;
        ChipColors colors3;
        boolean enabled2;
        Object value$iv$iv;
        Composer $composer2;
        ChipBorder border4;
        ChipColors colors4;
        boolean enabled3;
        int i5;
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer3 = $composer.startRestartGroup(170629701);
        ComposerKt.sourceInformation($composer3, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)523@26368L5,524@26423L22,525@26502L25,526@26578L22,527@26652L39,533@26828L10,534@26910L19,528@26697L540:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(onClick) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(label) ? 32 : 16;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty3 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty3 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
            $dirty3 |= 24576;
            function22 = function2;
        } else if (($changed & 57344) == 0) {
            function22 = function2;
            $dirty3 |= $composer3.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = function2;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                if ($composer3.changed(shape2)) {
                    i8 = 131072;
                    $dirty3 |= i8;
                }
            } else {
                shape2 = shape;
            }
            i8 = 65536;
            $dirty3 |= i8;
        } else {
            shape2 = shape;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(colors)) {
                i7 = 1048576;
                $dirty3 |= i7;
            }
            i7 = 524288;
            $dirty3 |= i7;
        }
        if ((29360128 & $changed) == 0) {
            if ((i & 128) == 0) {
                elevation2 = elevation;
                if ($composer3.changed(elevation2)) {
                    i6 = 8388608;
                    $dirty3 |= i6;
                }
            } else {
                elevation2 = elevation;
            }
            i6 = 4194304;
            $dirty3 |= i6;
        } else {
            elevation2 = elevation;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer3.changed(border)) {
                i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty3 |= i5;
            }
            i5 = 33554432;
            $dirty3 |= i5;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty3 |= 805306368;
            i2 = i12;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 1879048192) == 0) {
            i2 = i12;
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer3.changed(mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            i2 = i12;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            colors4 = colors;
            border4 = border;
            enabled3 = z;
            icon = function22;
            shape3 = shape2;
            interactionSource2 = mutableInteractionSource;
            elevation3 = elevation2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i9 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i10 != 0 ? true : z;
                icon = i11 != 0 ? null : function22;
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                    shape3 = SuggestionChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                    colors2 = SuggestionChipDefaults.INSTANCE.m1792suggestionChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer3, 1572864, 63);
                } else {
                    colors2 = colors;
                }
                if ((i & 128) != 0) {
                    $dirty = $dirty3 & (-29360129);
                    elevation2 = SuggestionChipDefaults.INSTANCE.m1793suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    $dirty = $dirty3;
                }
                if ((i & 256) != 0) {
                    i3 = i2;
                    modifier2 = modifier4;
                    i4 = 6;
                    border2 = SuggestionChipDefaults.INSTANCE.m1791suggestionChipBorderd_3_b6Q(0L, 0L, 0.0f, $composer3, 3072, 7);
                    $dirty &= -234881025;
                } else {
                    i3 = i2;
                    modifier2 = modifier4;
                    i4 = 6;
                    border2 = border;
                }
                if (i3 != 0) {
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
                    modifier3 = modifier2;
                    border3 = border2;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    elevation3 = elevation2;
                    $dirty2 = $dirty;
                    colors3 = colors2;
                    enabled2 = enabled4;
                } else {
                    modifier3 = modifier2;
                    interactionSource2 = interactionSource;
                    border3 = border2;
                    elevation3 = elevation2;
                    $dirty2 = $dirty;
                    colors3 = colors2;
                    enabled2 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    modifier3 = modifier;
                    interactionSource2 = interactionSource;
                    $dirty2 = (-234881025) & $dirty3;
                    icon = function22;
                    shape3 = shape2;
                    i4 = 6;
                    elevation3 = elevation2;
                    colors3 = colors;
                    enabled2 = z;
                    border3 = border;
                } else {
                    modifier3 = modifier;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty3;
                    icon = function22;
                    shape3 = shape2;
                    i4 = 6;
                    elevation3 = elevation2;
                    colors3 = colors;
                    enabled2 = z;
                    border3 = border;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(170629701, $dirty2, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:517)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i4), SuggestionChipTokens.INSTANCE.getLabelTextFont());
            long m2959unboximpl = colors3.labelColor$material3_release(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 15) & 112)).getValue().m2959unboximpl();
            $composer3.startReplaceableGroup(2118455055);
            ComposerKt.sourceInformation($composer3, "540@27074L21");
            State<BorderStroke> borderStroke$material3_release = border3 == null ? null : border3.borderStroke$material3_release(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 21) & 112));
            $composer3.endReplaceableGroup();
            $composer2 = $composer3;
            border4 = border3;
            colors4 = colors3;
            enabled3 = enabled2;
            m1345ChipnkUnTEs(modifier3, onClick, enabled2, label, fromToken, m2959unboximpl, icon, null, shape3, colors4, elevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, SuggestionChipDefaults.INSTANCE.m1789getHeightD9Ej5fM(), SuggestionChipPadding, interactionSource2, $composer2, (($dirty2 >> 6) & 14) | 12582912 | (($dirty2 << 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty2 << 6) & 7168) | (($dirty2 << 6) & 3670016) | (($dirty2 << 9) & 234881024) | (($dirty2 << 9) & 1879048192), (($dirty2 >> 21) & 14) | 3456 | (($dirty2 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z2 = enabled3;
        final Function2 function23 = icon;
        final Shape shape4 = shape3;
        final ChipColors chipColors = colors4;
        final ChipElevation chipElevation = elevation3;
        final ChipBorder chipBorder = border4;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SuggestionChip$2
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

            public final void invoke(Composer composer, int i13) {
                ChipKt.SuggestionChip(onClick, label, modifier5, z2, function23, shape4, chipColors, chipElevation, chipBorder, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void ElevatedSuggestionChip(final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function2 function22;
        Shape shape2;
        ChipColors colors2;
        int i2;
        MutableInteractionSource mutableInteractionSource;
        Modifier modifier2;
        Function2 icon;
        Shape shape3;
        int $dirty;
        ChipColors colors3;
        int i3;
        int i4;
        ChipElevation elevation2;
        MutableInteractionSource interactionSource2;
        ChipBorder border2;
        ChipElevation elevation3;
        int $dirty2;
        boolean enabled2;
        Object value$iv$iv;
        ChipBorder border3;
        ChipColors colors4;
        boolean enabled3;
        Composer $composer2;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer3 = $composer.startRestartGroup(1668751803);
        ComposerKt.sourceInformation($composer3, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)591@29894L5,592@29949L30,593@30036L33,595@30153L39,601@30329L10,602@30411L19,596@30198L540:Chip.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(onClick) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(label) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty3 |= 24576;
            function22 = function2;
        } else if (($changed & 57344) == 0) {
            function22 = function2;
            $dirty3 |= $composer3.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = function2;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                if ($composer3.changed(shape2)) {
                    i7 = 131072;
                    $dirty3 |= i7;
                }
            } else {
                shape2 = shape;
            }
            i7 = 65536;
            $dirty3 |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                colors2 = colors;
                if ($composer3.changed(colors2)) {
                    i6 = 1048576;
                    $dirty3 |= i6;
                }
            } else {
                colors2 = colors;
            }
            i6 = 524288;
            $dirty3 |= i6;
        } else {
            colors2 = colors;
        }
        if ((29360128 & $changed) == 0) {
            if ((i & 128) == 0 && $composer3.changed(elevation)) {
                i5 = 8388608;
                $dirty3 |= i5;
            }
            i5 = 4194304;
            $dirty3 |= i5;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changed(border) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty3 |= 805306368;
            i2 = i12;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 1879048192) == 0) {
            i2 = i12;
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer3.changed(mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            i2 = i12;
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 1533916891) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled3 = enabled;
            elevation3 = elevation;
            border3 = border;
            icon = function22;
            shape3 = shape2;
            colors4 = colors2;
            interactionSource2 = mutableInteractionSource;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier2 = i8 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i9 != 0 ? true : enabled;
                icon = i10 != 0 ? null : function22;
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                    shape3 = SuggestionChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty3 & (-3670017);
                    colors3 = SuggestionChipDefaults.INSTANCE.m1787elevatedSuggestionChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer3, 1572864, 63);
                } else {
                    $dirty = $dirty3;
                    colors3 = colors2;
                }
                if ((i & 128) != 0) {
                    i3 = i2;
                    i4 = 6;
                    elevation2 = SuggestionChipDefaults.INSTANCE.m1788elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty &= -29360129;
                } else {
                    i3 = i2;
                    i4 = 6;
                    elevation2 = elevation;
                }
                ChipBorder border4 = i11 != 0 ? null : border;
                if (i3 != 0) {
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
                    border2 = border4;
                    elevation3 = elevation2;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    colors2 = colors3;
                    $dirty2 = $dirty;
                    enabled2 = enabled4;
                } else {
                    interactionSource2 = interactionSource;
                    border2 = border4;
                    elevation3 = elevation2;
                    colors2 = colors3;
                    $dirty2 = $dirty;
                    enabled2 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty3 & (-29360129);
                    icon = function22;
                    shape3 = shape2;
                    i4 = 6;
                    enabled2 = enabled;
                    border2 = border;
                } else {
                    modifier2 = modifier;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty3;
                    icon = function22;
                    shape3 = shape2;
                    i4 = 6;
                    enabled2 = enabled;
                    border2 = border;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1668751803, $dirty2, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:585)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i4), SuggestionChipTokens.INSTANCE.getLabelTextFont());
            long m2959unboximpl = colors2.labelColor$material3_release(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 15) & 112)).getValue().m2959unboximpl();
            float m1789getHeightD9Ej5fM = SuggestionChipDefaults.INSTANCE.m1789getHeightD9Ej5fM();
            PaddingValues paddingValues = SuggestionChipPadding;
            $composer3.startReplaceableGroup(-1455593716);
            ComposerKt.sourceInformation($composer3, "610@30665L21");
            State<BorderStroke> borderStroke$material3_release = border2 == null ? null : border2.borderStroke$material3_release(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 21) & 112));
            $composer3.endReplaceableGroup();
            border3 = border2;
            colors4 = colors2;
            enabled3 = enabled2;
            $composer2 = $composer3;
            m1345ChipnkUnTEs(modifier2, onClick, enabled2, label, fromToken, m2959unboximpl, icon, null, shape3, colors4, elevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m1789getHeightD9Ej5fM, paddingValues, interactionSource2, $composer2, (($dirty2 >> 6) & 14) | 12582912 | (($dirty2 << 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty2 << 6) & 7168) | (($dirty2 << 6) & 3670016) | (($dirty2 << 9) & 234881024) | (($dirty2 << 9) & 1879048192), (($dirty2 >> 21) & 14) | 3456 | (($dirty2 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final boolean z = enabled3;
        final Function2 function23 = icon;
        final Shape shape4 = shape3;
        final ChipColors chipColors = colors4;
        final ChipElevation chipElevation = elevation3;
        final ChipBorder chipBorder = border3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedSuggestionChip$2
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

            public final void invoke(Composer composer, int i13) {
                ChipKt.ElevatedSuggestionChip(onClick, label, modifier3, z, function23, shape4, chipColors, chipElevation, chipBorder, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Chip-nkUnTEs, reason: not valid java name */
    public static final void m1345ChipnkUnTEs(final Modifier modifier, final Function0<Unit> function0, final boolean enabled, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle labelTextStyle, final long labelColor, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Shape shape, final ChipColors colors, final ChipElevation elevation, final BorderStroke border, final float minHeight, final PaddingValues paddingValues, final MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1) {
        Composer $composer2;
        int $dirty;
        Composer $composer3 = $composer.startRestartGroup(1400504719);
        ComposerKt.sourceInformation($composer3, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1323@66508L23,1318@66337L961:Chip.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(labelTextStyle) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty2 |= $composer3.changed(labelColor) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function23) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(shape) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer3.changed(colors) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(elevation) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changed(border) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(minHeight) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(paddingValues) ? 2048 : 1024;
        }
        if (($changed1 & 57344) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 16384 : 8192;
        }
        if (($dirty2 & 1533916891) != 306783378 || (46811 & $dirty1) != 9362 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400504719, $dirty2, $dirty1, "androidx.compose.material3.Chip (Chip.kt:1301)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.m4582setRolekuIjeqM(semantics, Role.INSTANCE.m4568getButtono7Vup1c());
                }
            }, 1, null);
            long m2959unboximpl = colors.containerColor$material3_release(enabled, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 24) & 112)).getValue().m2959unboximpl();
            $composer3.startReplaceableGroup(64018752);
            ComposerKt.sourceInformation($composer3, "1324@66575L42");
            State<Dp> state = elevation == null ? null : elevation.tonalElevation$material3_release(enabled, interactionSource, $composer3, (($dirty2 >> 6) & 14) | (($dirty1 >> 9) & 112) | (($dirty1 << 6) & 896));
            $composer3.endReplaceableGroup();
            float m5232unboximpl = state != null ? state.getValue().m5232unboximpl() : Dp.m5218constructorimpl(0);
            $composer3.startReplaceableGroup(64018848);
            ComposerKt.sourceInformation($composer3, "1325@66671L43");
            State<Dp> shadowElevation$material3_release = elevation == null ? null : elevation.shadowElevation$material3_release(enabled, interactionSource, $composer3, (($dirty2 >> 6) & 14) | (($dirty1 >> 9) & 112) | (($dirty1 << 6) & 896));
            $composer3.endReplaceableGroup();
            float m5232unboximpl2 = shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().m5232unboximpl() : Dp.m5218constructorimpl(0);
            final int $dirty3 = $dirty2;
            final int $dirty12 = $dirty1;
            $composer2 = $composer3;
            $dirty = $dirty3;
            SurfaceKt.m1797Surfaceo_FOJdg(function0, semantics$default, enabled, shape, m2959unboximpl, 0L, m5232unboximpl, m5232unboximpl2, border, interactionSource, ComposableLambdaKt.composableLambda($composer2, -1985962652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C1336@67086L32,1337@67165L33,1329@66819L473:Chip.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1985962652, $changed2, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1328)");
                        }
                        ChipKt.m1346ChipContentfe0OD_I(function2, labelTextStyle, labelColor, function22, null, function23, colors.leadingIconContentColor$material3_release(enabled, $composer4, (($dirty3 >> 6) & 14) | (($dirty3 >> 24) & 112)).getValue().m2959unboximpl(), colors.trailingIconContentColor$material3_release(enabled, $composer4, (($dirty3 >> 6) & 14) | (($dirty3 >> 24) & 112)).getValue().m2959unboximpl(), minHeight, paddingValues, $composer4, (($dirty3 >> 9) & 14) | 24576 | (($dirty3 >> 9) & 112) | (($dirty3 >> 9) & 896) | (($dirty3 >> 9) & 7168) | (($dirty3 >> 6) & 458752) | (($dirty12 << 18) & 234881024) | (($dirty12 << 18) & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | ($dirty & 896) | (($dirty >> 15) & 7168) | (($dirty12 << 21) & 234881024) | (($dirty12 << 15) & 1879048192), 6, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $dirty = $dirty2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$3
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

            public final void invoke(Composer composer, int i) {
                ChipKt.m1345ChipnkUnTEs(Modifier.this, function0, enabled, function2, labelTextStyle, labelColor, function22, function23, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SelectableChip-u0RnIRE, reason: not valid java name */
    public static final void m1347SelectableChipu0RnIRE(final boolean selected, final Modifier modifier, final Function0<Unit> function0, final boolean enabled, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle labelTextStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors colors, final SelectableChipElevation elevation, final BorderStroke border, final float minHeight, final PaddingValues paddingValues, final MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation($composer3, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)1371@68165L33,1365@67963L1080:Chip.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(selected) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty |= $composer3.changed(labelTextStyle) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changedInstance(function24) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(shape) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(colors) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changed(elevation) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(border) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(minHeight) ? 2048 : 1024;
        }
        if (($changed1 & 57344) == 0) {
            $dirty1 |= $composer3.changed(paddingValues) ? 16384 : 8192;
        }
        if (($changed1 & 458752) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 131072 : 65536;
        }
        if (($dirty & 1533916891) != 306783378 || (374491 & $dirty1) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, $dirty, $dirty1, "androidx.compose.material3.SelectableChip (Chip.kt:1346)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.m4582setRolekuIjeqM(semantics, Role.INSTANCE.m4569getCheckboxo7Vup1c());
                }
            }, 1, null);
            long m2959unboximpl = colors.containerColor$material3_release(enabled, selected, $composer3, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty1 << 6) & 896)).getValue().m2959unboximpl();
            $composer3.startReplaceableGroup(1036660941);
            ComposerKt.sourceInformation($composer3, "1372@68242L42");
            State<Dp> state = elevation == null ? null : elevation.tonalElevation$material3_release(enabled, interactionSource, $composer3, (($dirty >> 9) & 14) | (($dirty1 >> 12) & 112) | (($dirty1 << 3) & 896));
            $composer3.endReplaceableGroup();
            float m5232unboximpl = state != null ? state.getValue().m5232unboximpl() : Dp.m5218constructorimpl(0);
            $composer3.startReplaceableGroup(1036661049);
            ComposerKt.sourceInformation($composer3, "1374@68350L43");
            State<Dp> shadowElevation$material3_release = elevation != null ? elevation.shadowElevation$material3_release(enabled, interactionSource, $composer3, (($dirty >> 9) & 14) | (($dirty1 >> 12) & 112) | (($dirty1 << 3) & 896)) : null;
            $composer3.endReplaceableGroup();
            final int $dirty2 = $dirty;
            final int $dirty12 = $dirty1;
            $composer2 = $composer3;
            SurfaceKt.m1795Surfaced85dljk(selected, function0, semantics$default, enabled, shape, m2959unboximpl, 0L, m5232unboximpl, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().m5232unboximpl() : Dp.m5218constructorimpl(0), border, interactionSource, ComposableLambdaKt.composableLambda($composer3, -577614814, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C1384@68695L29,1386@68811L42,1387@68900L43,1379@68510L527:Chip.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-577614814, $changed2, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:1378)");
                        }
                        long m2959unboximpl2 = SelectableChipColors.this.labelColor$material3_release(enabled, selected, $composer4, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty12 << 6) & 896)).getValue().m2959unboximpl();
                        long m2959unboximpl3 = SelectableChipColors.this.leadingIconContentColor$material3_release(enabled, selected, $composer4, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty12 << 6) & 896)).getValue().m2959unboximpl();
                        long m2959unboximpl4 = SelectableChipColors.this.trailingIconContentColor$material3_release(enabled, selected, $composer4, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty12 << 6) & 896)).getValue().m2959unboximpl();
                        ChipKt.m1346ChipContentfe0OD_I(function2, labelTextStyle, m2959unboximpl2, function22, function23, function24, m2959unboximpl3, m2959unboximpl4, minHeight, paddingValues, $composer4, (($dirty12 << 15) & 1879048192) | (($dirty2 >> 12) & 14) | (($dirty2 >> 12) & 112) | (($dirty2 >> 9) & 7168) | (($dirty2 >> 9) & 57344) | (($dirty2 >> 9) & 458752) | (($dirty12 << 15) & 234881024));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, ($dirty2 & 14) | (($dirty2 >> 3) & 112) | ($dirty2 & 7168) | (($dirty2 >> 15) & 57344) | (($dirty12 << 21) & 1879048192), (($dirty12 >> 15) & 14) | 48, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$3
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

            public final void invoke(Composer composer, int i) {
                ChipKt.m1347SelectableChipu0RnIRE(selected, modifier, function0, enabled, function2, labelTextStyle, function22, function23, function24, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I, reason: not valid java name */
    public static final void m1346ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle labelTextStyle, final long labelColor, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long leadingIconColor, final long trailingIconColor, final float minHeight, final PaddingValues paddingValues, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-782878228);
        ComposerKt.sourceInformation($composer2, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)1407@69420L1012:Chip.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(labelTextStyle) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(labelColor) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function24) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(leadingIconColor) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer2.changed(trailingIconColor) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= $composer2.changed(minHeight) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changed(paddingValues) ? 536870912 : 268435456;
        }
        if (($dirty & 1533916891) != 306783378 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, $dirty, -1, "androidx.compose.material3.ChipContent (Chip.kt:1395)");
            }
            final int i = $dirty;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(labelColor)), TextKt.getLocalTextStyle().provides(labelTextStyle)}, ComposableLambdaKt.composableLambda($composer2, 1748799148, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    float f;
                    float f2;
                    ComposerKt.sourceInformation($composer3, "C1411@69556L870:Chip.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1748799148, $changed2, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:1410)");
                        }
                        Modifier modifier$iv = PaddingKt.padding(SizeKt.m516defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, minHeight, 1, null), paddingValues);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function25 = function23;
                        int i2 = i;
                        Function2<Composer, Integer, Unit> function26 = function22;
                        long j = leadingIconColor;
                        Function2<Composer, Integer, Unit> function27 = function2;
                        Function2<Composer, Integer, Unit> function28 = function24;
                        long j2 = trailingIconColor;
                        $composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer3, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv = (Density) consume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer3.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            $composer3.useNode();
                        }
                        $composer3.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer3);
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer3.startReplaceableGroup(2058660585);
                        int i3 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i4 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 650988016, "C1425@70082L49,1426@70144L7,1427@70164L49:Chip.kt#uh7d8r");
                        if (function25 != null) {
                            $composer3.startReplaceableGroup(650988036);
                            ComposerKt.sourceInformation($composer3, "1419@69854L8");
                            function25.invoke($composer3, Integer.valueOf((i2 >> 12) & 14));
                            $composer3.endReplaceableGroup();
                        } else if (function26 != null) {
                            $composer3.startReplaceableGroup(650988107);
                            ComposerKt.sourceInformation($composer3, "1421@69925L130");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(j))}, function26, $composer3, ((i2 >> 6) & 112) | 8);
                            $composer3.endReplaceableGroup();
                        } else {
                            $composer3.startReplaceableGroup(650988269);
                            $composer3.endReplaceableGroup();
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f = ChipKt.HorizontalElementsPadding;
                        SpacerKt.Spacer(SizeKt.m536width3ABfNKs(companion, f), $composer3, 6);
                        function27.invoke($composer3, Integer.valueOf(i2 & 14));
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        f2 = ChipKt.HorizontalElementsPadding;
                        SpacerKt.Spacer(SizeKt.m536width3ABfNKs(companion2, f2), $composer3, 6);
                        $composer3.startReplaceableGroup(-313068567);
                        ComposerKt.sourceInformation($composer3, "1429@70270L132");
                        if (function28 != null) {
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(j2))}, function28, $composer3, ((i2 >> 12) & 112) | 8);
                        }
                        $composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$2
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

            public final void invoke(Composer composer, int i2) {
                ChipKt.m1346ChipContentfe0OD_I(function2, labelTextStyle, labelColor, function22, function23, function24, leadingIconColor, trailingIconColor, minHeight, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    private static final PaddingValues inputChipPadding(boolean hasAvatar, boolean hasLeadingIcon, boolean hasTrailingIcon) {
        float start = (hasAvatar || !hasLeadingIcon) ? Dp.m5218constructorimpl(4) : Dp.m5218constructorimpl(8);
        float end = hasTrailingIcon ? Dp.m5218constructorimpl(8) : Dp.m5218constructorimpl(4);
        return PaddingKt.m481PaddingValuesa9UjIt4$default(start, 0.0f, end, 0.0f, 10, null);
    }
}
