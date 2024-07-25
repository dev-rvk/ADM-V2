package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Card.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Card-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Card-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Card-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CardKt {
    /* renamed from: Card-F-jzlyU, reason: not valid java name */
    public static final void m1012CardFjzlyU(Modifier modifier, Shape shape, long backgroundColor, long contentColor, BorderStroke border, float elevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Shape shape2;
        long backgroundColor2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(1956755640);
        ComposerKt.sourceInformation($composer, "C(Card)P(5,6,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)60@2616L6,61@2674L6,62@2716L32,67@2854L218:Card.kt#jmzs0o");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 2) == 0) {
            shape2 = shape;
        } else {
            shape2 = MaterialTheme.INSTANCE.getShapes($composer, 6).getMedium();
        }
        if ((i & 4) == 0) {
            backgroundColor2 = backgroundColor;
        } else {
            backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU();
        }
        if ((i & 8) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorsKt.m1054contentColorForek8zF_U(backgroundColor2, $composer, ($changed >> 6) & 14);
        }
        if ((i & 16) == 0) {
            border2 = border;
        } else {
            border2 = null;
        }
        if ((i & 32) == 0) {
            elevation2 = elevation;
        } else {
            elevation2 = Dp.m5218constructorimpl(1);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1956755640, $changed, -1, "androidx.compose.material.Card (Card.kt:58)");
        }
        SurfaceKt.m1198SurfaceFjzlyU(modifier2, shape2, backgroundColor2, contentColor2, border2, elevation2, content, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Card-LPr_se0, reason: not valid java name */
    public static final void m1013CardLPr_se0(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long backgroundColor, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        boolean enabled2;
        Shape shape2;
        long backgroundColor2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        MutableInteractionSource interactionSource2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(778538979);
        ComposerKt.sourceInformation($composer, "C(Card)P(8,7,5,9,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)111@4759L6,112@4817L6,113@4859L32,116@5003L39,119@5088L319:Card.kt#jmzs0o");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 4) == 0) {
            enabled2 = enabled;
        } else {
            enabled2 = true;
        }
        if ((i & 8) == 0) {
            shape2 = shape;
        } else {
            shape2 = MaterialTheme.INSTANCE.getShapes($composer, 6).getMedium();
        }
        if ((i & 16) == 0) {
            backgroundColor2 = backgroundColor;
        } else {
            backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU();
        }
        if ((i & 32) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorsKt.m1054contentColorForek8zF_U(backgroundColor2, $composer, ($changed >> 12) & 14);
        }
        if ((i & 64) == 0) {
            border2 = border;
        } else {
            border2 = null;
        }
        if ((i & 128) == 0) {
            elevation2 = elevation;
        } else {
            elevation2 = Dp.m5218constructorimpl(1);
        }
        if ((i & 256) == 0) {
            interactionSource2 = interactionSource;
        } else {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = (MutableInteractionSource) value$iv$iv;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(778538979, $changed, -1, "androidx.compose.material.Card (Card.kt:107)");
        }
        SurfaceKt.m1199SurfaceLPr_se0(onClick, modifier2, enabled2, shape2, backgroundColor2, contentColor2, border2, elevation2, interactionSource2, content, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed) | (29360128 & $changed) | (234881024 & $changed) | (1879048192 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Card function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Card(onClick, modifier, enabled, shape, backgroundColor, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Card-9VG74zQ, reason: not valid java name */
    public static final void m1011Card9VG74zQ(Function0<Unit> onClick, Modifier modifier, Shape shape, long backgroundColor, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        MutableInteractionSource interactionSource2;
        Indication indication2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(1353606722);
        ComposerKt.sourceInformation($composer, "C(Card)P(9,8,12,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)182@7959L6,183@8017L6,184@8059L32,187@8203L39,188@8290L7,195@8465L410:Card.kt#jmzs0o");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        Shape shape2 = (i & 4) != 0 ? MaterialTheme.INSTANCE.getShapes($composer, 6).getMedium() : shape;
        long backgroundColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU() : backgroundColor;
        long contentColor2 = (i & 16) != 0 ? ColorsKt.m1054contentColorForek8zF_U(backgroundColor2, $composer, ($changed >> 9) & 14) : contentColor;
        BorderStroke border2 = (i & 32) != 0 ? null : border;
        float elevation2 = (i & 64) != 0 ? Dp.m5218constructorimpl(1) : elevation;
        if ((i & 128) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = (MutableInteractionSource) value$iv$iv;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((i & 256) != 0) {
            ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localIndication);
            ComposerKt.sourceInformationMarkerEnd($composer);
            indication2 = (Indication) consume;
        } else {
            indication2 = indication;
        }
        boolean enabled2 = (i & 512) != 0 ? true : enabled;
        String onClickLabel2 = (i & 1024) != 0 ? null : onClickLabel;
        Role role2 = (i & 2048) != 0 ? null : role;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1353606722, $changed, $changed1, "androidx.compose.material.Card (Card.kt:179)");
        }
        SurfaceKt.m1197Surface9VG74zQ(onClick, modifier2, shape2, backgroundColor2, contentColor2, border2, elevation2, interactionSource2, indication2, enabled2, onClickLabel2, role2, content, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed) | (29360128 & $changed) | (234881024 & $changed) | (1879048192 & $changed), ($changed1 & 14) | ($changed1 & 112) | ($changed1 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }
}
