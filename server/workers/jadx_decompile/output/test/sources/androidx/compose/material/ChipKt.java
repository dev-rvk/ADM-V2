package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u008e\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÄ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float HorizontalPadding = Dp.m5218constructorimpl(12);
    private static final float LeadingIconStartSpacing = Dp.m5218constructorimpl(4);
    private static final float LeadingIconEndSpacing = Dp.m5218constructorimpl(8);
    private static final float TrailingIconSpacing = Dp.m5218constructorimpl(8);
    private static final float SelectedIconContainerSize = Dp.m5218constructorimpl(24);

    /* JADX WARN: Removed duplicated region for block: B:46:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Chip(final kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, androidx.compose.ui.graphics.Shape r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.material.ChipColors r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.Chip(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Chip$lambda$1(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2959unboximpl();
    }

    public static final void FilterChip(final boolean selected, final Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, SelectableChipColors colors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        CornerBasedShape shape2;
        SelectableChipColors colors2;
        Function2 trailingIcon;
        Function2 leadingIcon;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        Function2 selectedIcon;
        BorderStroke border2;
        SelectableChipColors colors3;
        boolean enabled3;
        int $dirty;
        Object value$iv$iv;
        long m2947copywmQWz5c;
        final SelectableChipColors colors4;
        final boolean enabled4;
        Modifier modifier4;
        Composer $composer2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-1259208246);
        ComposerKt.sourceInformation($composer3, "C(FilterChip)P(8,7,6,3,4,10!2,5,9,11)188@8733L39,189@8807L6,191@8934L18,198@9265L31,205@9503L34,199@9301L4037:Chip.kt#jmzs0o");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
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
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(shape)) {
                i3 = 131072;
                $dirty2 |= i3;
            }
            i3 = 65536;
            $dirty2 |= i3;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer3.changed(border) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(function23) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(content) ? 32 : 16;
        }
        final int $dirty12 = $dirty1;
        if ((1533916891 & $dirty2) == 306783378 && ($dirty12 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled4 = enabled;
            interactionSource3 = interactionSource;
            shape3 = shape;
            border2 = border;
            colors4 = colors;
            leadingIcon = function2;
            selectedIcon = function22;
            trailingIcon = function23;
            modifier4 = modifier2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled5 = i5 != 0 ? true : enabled;
                if (i6 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    modifier3 = modifier5;
                    Object it$iv$iv = $composer3.rememberedValue();
                    enabled2 = enabled5;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier3 = modifier5;
                    enabled2 = enabled5;
                    interactionSource2 = interactionSource;
                }
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty2 &= -458753;
                } else {
                    shape2 = shape;
                }
                BorderStroke border3 = i7 != 0 ? null : border;
                if ((i & 128) != 0) {
                    colors2 = ChipDefaults.INSTANCE.m1020filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    $dirty2 &= -29360129;
                } else {
                    colors2 = colors;
                }
                Function2 leadingIcon2 = i8 != 0 ? null : function2;
                Function2 selectedIcon2 = i9 != 0 ? null : function22;
                if (i10 != 0) {
                    leadingIcon = leadingIcon2;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    selectedIcon = selectedIcon2;
                    trailingIcon = null;
                    border2 = border3;
                    colors3 = colors2;
                    modifier2 = modifier3;
                    enabled3 = enabled2;
                    $dirty = $dirty2;
                } else {
                    trailingIcon = function23;
                    leadingIcon = leadingIcon2;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    selectedIcon = selectedIcon2;
                    border2 = border3;
                    colors3 = colors2;
                    modifier2 = modifier3;
                    enabled3 = enabled2;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 128) != 0) {
                    enabled3 = enabled;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    border2 = border;
                    colors3 = colors;
                    leadingIcon = function2;
                    selectedIcon = function22;
                    trailingIcon = function23;
                    $dirty = (-29360129) & $dirty2;
                } else {
                    enabled3 = enabled;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    border2 = border;
                    colors3 = colors;
                    leadingIcon = function2;
                    selectedIcon = function22;
                    trailingIcon = function23;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1259208246, $dirty, $dirty12, "androidx.compose.material.FilterChip (Chip.kt:183)");
            }
            final State contentColor = colors3.contentColor(enabled3, selected, $composer3, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 15) & 896));
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$2
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
            long m2959unboximpl = colors3.backgroundColor(enabled3, selected, $composer3, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 15) & 896)).getValue().m2959unboximpl();
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r0, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r0) : 1.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r0) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r0) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor.getValue().m2959unboximpl()) : 0.0f);
            final Function2 function24 = leadingIcon;
            final int $dirty3 = $dirty;
            final Function2 function25 = selectedIcon;
            colors4 = colors3;
            final Function2 function26 = trailingIcon;
            enabled4 = enabled3;
            modifier4 = modifier2;
            $composer2 = $composer3;
            SurfaceKt.m1200SurfaceNy5ogXk(selected, onClick, semantics$default, enabled4, shape3, m2959unboximpl, m2947copywmQWz5c, border2, 0.0f, interactionSource3, ComposableLambdaKt.composableLambda($composer3, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3
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
                    ComposerKt.sourceInformation($composer4, "C210@9687L3645:Chip.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(722126431, $changed2, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:209)");
                        }
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2951getAlphaimpl(contentColor.getValue().m2959unboximpl())))};
                        final Function2<Composer, Integer, Unit> function27 = function24;
                        final boolean z = selected;
                        final Function2<Composer, Integer, Unit> function28 = function25;
                        final Function2<Composer, Integer, Unit> function29 = function26;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                        final int i11 = $dirty12;
                        final SelectableChipColors selectableChipColors = colors4;
                        final boolean z2 = enabled4;
                        final int i12 = $dirty3;
                        final State<Color> state = contentColor;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3.1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C212@9835L10,211@9779L3543:Chip.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1582291359, $changed3, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:210)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer5, 6).getBody2();
                                    final Function2<Composer, Integer, Unit> function210 = function27;
                                    final boolean z3 = z;
                                    final Function2<Composer, Integer, Unit> function211 = function28;
                                    final Function2<Composer, Integer, Unit> function212 = function29;
                                    final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    final int i13 = i11;
                                    final SelectableChipColors selectableChipColors2 = selectableChipColors;
                                    final boolean z4 = z2;
                                    final int i14 = i12;
                                    final State<Color> state2 = state;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda($composer5, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
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

                                        /* JADX WARN: Removed duplicated region for block: B:39:0x0583  */
                                        /* JADX WARN: Removed duplicated region for block: B:42:0x05cd  */
                                        /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
                                        /* JADX WARN: Removed duplicated region for block: B:47:0x024a  */
                                        /* JADX WARN: Removed duplicated region for block: B:50:0x0256  */
                                        /* JADX WARN: Removed duplicated region for block: B:58:0x0315  */
                                        /* JADX WARN: Removed duplicated region for block: B:61:0x0379 A[ADDED_TO_REGION] */
                                        /* JADX WARN: Removed duplicated region for block: B:64:0x0399  */
                                        /* JADX WARN: Removed duplicated region for block: B:67:0x0446  */
                                        /* JADX WARN: Removed duplicated region for block: B:70:0x0452  */
                                        /* JADX WARN: Removed duplicated region for block: B:79:0x0458  */
                                        /* JADX WARN: Removed duplicated region for block: B:80:0x03e3  */
                                        /* JADX WARN: Removed duplicated region for block: B:82:0x0365  */
                                        /* JADX WARN: Removed duplicated region for block: B:85:0x025c  */
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                            To view partially-correct add '--show-bad-code' argument
                                        */
                                        public final void invoke(androidx.compose.runtime.Composer r77, int r78) {
                                            /*
                                                Method dump skipped, instructions count: 1489
                                                To view this dump add '--comments-level debug' option
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt$FilterChip$3.AnonymousClass1.C00261.invoke(androidx.compose.runtime.Composer, int):void");
                                        }
                                    }), $composer5, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 7168) | (($dirty3 >> 3) & 57344) | (($dirty3 << 3) & 29360128) | (($dirty3 << 15) & 1879048192), 6, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z = enabled4;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        final Shape shape4 = shape3;
        final BorderStroke borderStroke = border2;
        final SelectableChipColors selectableChipColors = colors4;
        final Function2 function27 = leadingIcon;
        final Function2 function28 = selectedIcon;
        final Function2 function29 = trailingIcon;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$4
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

            public final void invoke(Composer composer, int i11) {
                ChipKt.FilterChip(selected, onClick, modifier6, z, mutableInteractionSource, shape4, borderStroke, selectableChipColors, function27, function28, function29, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }
}
