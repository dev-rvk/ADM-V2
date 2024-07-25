package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidMenu.android.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u008e\u0001\u0010\u0013\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:27:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ee  */
    /* renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1296DropdownMenuILWXrKs(final boolean r34, final kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.ui.Modifier r36, long r37, androidx.compose.ui.window.PopupProperties r39, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidMenu_androidKt.m1296DropdownMenuILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void DropdownMenuItem(final Function2<? super Composer, ? super Integer, Unit> text, final Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean enabled, MenuItemColors colors, PaddingValues contentPadding, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function2 function23;
        boolean z;
        MenuItemColors colors2;
        PaddingValues contentPadding2;
        int $dirty;
        MutableInteractionSource interactionSource2;
        Modifier modifier2;
        Function2 leadingIcon;
        Function2 trailingIcon;
        boolean enabled2;
        MenuItemColors colors3;
        Object value$iv$iv;
        Composer $composer2;
        int i2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(1826340448);
        ComposerKt.sourceInformation($composer3, "C(DropdownMenuItem)P(7,6,5,4,8,2)144@6904L12,146@7049L39,148@7098L319:AndroidMenu.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(text) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            function23 = function22;
        } else if (($changed & 57344) == 0) {
            function23 = function22;
            $dirty2 |= $composer3.changedInstance(function23) ? 16384 : 8192;
        } else {
            function23 = function22;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = enabled;
        } else if (($changed & 458752) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 131072 : 65536;
        } else {
            z = enabled;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(colors)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer3.changed(contentPadding) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon = function2;
            colors3 = colors;
            contentPadding2 = contentPadding;
            interactionSource2 = interactionSource;
            trailingIcon = function23;
            $composer2 = $composer3;
            enabled2 = z;
            modifier2 = modifier;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
                Function2 leadingIcon2 = i4 != 0 ? null : function2;
                Function2 trailingIcon2 = i5 != 0 ? null : function23;
                boolean enabled3 = i6 != 0 ? true : z;
                if ((i & 64) != 0) {
                    colors2 = MenuDefaults.INSTANCE.m1598itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer3, 1572864, 63);
                    $dirty2 &= -3670017;
                } else {
                    colors2 = colors;
                }
                PaddingValues contentPadding3 = i7 != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : contentPadding;
                if (i8 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    PaddingValues contentPadding4 = contentPadding3;
                    Object it$iv$iv = $composer3.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    contentPadding2 = contentPadding4;
                    $dirty = $dirty3;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    modifier2 = modifier3;
                    leadingIcon = leadingIcon2;
                    trailingIcon = trailingIcon2;
                    enabled2 = enabled3;
                    colors3 = colors2;
                } else {
                    contentPadding2 = contentPadding3;
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    leadingIcon = leadingIcon2;
                    trailingIcon = trailingIcon2;
                    enabled2 = enabled3;
                    colors3 = colors2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    leadingIcon = function2;
                    colors3 = colors;
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2 & (-3670017);
                    trailingIcon = function23;
                    enabled2 = z;
                    modifier2 = modifier;
                } else {
                    leadingIcon = function2;
                    colors3 = colors;
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                    trailingIcon = function23;
                    enabled2 = z;
                    modifier2 = modifier;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1826340448, $dirty, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
            }
            $composer2 = $composer3;
            MenuKt.DropdownMenuItemContent(text, onClick, modifier2, leadingIcon, trailingIcon, enabled2, colors3, contentPadding2, interactionSource2, $composer3, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128) | ($dirty & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final Function2 function24 = leadingIcon;
        final Function2 function25 = trailingIcon;
        final boolean z2 = enabled2;
        final MenuItemColors menuItemColors = colors3;
        final PaddingValues paddingValues = contentPadding2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenuItem$2
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

            public final void invoke(Composer composer, int i9) {
                AndroidMenu_androidKt.DropdownMenuItem(text, onClick, modifier4, function24, function25, z2, menuItemColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
