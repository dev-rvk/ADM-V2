package androidx.compose.material.ripple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Ripple.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\fJI\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "findNearestViewGroup", "Landroid/view/ViewGroup;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/ViewGroup;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlatformRipple extends Ripple {
    public /* synthetic */ PlatformRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private PlatformRipple(boolean bounded, float radius, State<Color> color) {
        super(bounded, radius, color, null);
        Intrinsics.checkNotNullParameter(color, "color");
    }

    @Override // androidx.compose.material.ripple.Ripple
    /* renamed from: rememberUpdatedRippleInstance-942rkJo */
    public RippleIndicationInstance mo1277rememberUpdatedRippleInstance942rkJo(InteractionSource interactionSource, boolean bounded, float radius, State<Color> color, State<RippleAlpha> rippleAlpha, Composer $composer, int $changed) {
        Object rippleContainer;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        $composer.startReplaceableGroup(331259447);
        ComposerKt.sourceInformation($composer, "C(rememberUpdatedRippleInstance)P(2!1,3:c#ui.unit.Dp)64@2484L22,90@3354L160:Ripple.android.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(331259447, $changed, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:57)");
        }
        ViewGroup view = findNearestViewGroup($composer, ($changed >> 15) & 14);
        $composer.startReplaceableGroup(1643267286);
        ComposerKt.sourceInformation($composer, "67@2658L133");
        if (!view.isInEditMode()) {
            $composer.endReplaceableGroup();
            Object rippleContainer2 = null;
            int index = 0;
            int childCount = view.getChildCount();
            while (true) {
                if (index >= childCount) {
                    break;
                }
                Object child = view.getChildAt(index);
                if (!(child instanceof RippleContainer)) {
                    index++;
                } else {
                    rippleContainer2 = child;
                    break;
                }
            }
            if (rippleContainer2 != null) {
                rippleContainer = rippleContainer2;
            } else {
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                Object $this$rememberUpdatedRippleInstance_942rkJo_u24lambda_u241 = new RippleContainer(context);
                view.addView((View) $this$rememberUpdatedRippleInstance_942rkJo_u24lambda_u241);
                rippleContainer = $this$rememberUpdatedRippleInstance_942rkJo_u24lambda_u241;
            }
            int i = ($changed & 14) | 512 | (($changed >> 12) & 112);
            Object key3$iv = rippleContainer;
            $composer.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(interactionSource) | $composer.changed(this) | $composer.changed(key3$iv);
            Object value$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new AndroidRippleIndicationInstance(bounded, radius, color, rippleAlpha, (RippleContainer) rippleContainer, null);
                $composer.updateRememberedValue(value$iv$iv);
            }
            $composer.endReplaceableGroup();
            AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) value$iv$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return androidRippleIndicationInstance;
        }
        int i2 = ($changed & 14) | (($changed >> 12) & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(interactionSource) | $composer.changed(this);
        Object value$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv2 || value$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = new CommonRippleIndicationInstance(bounded, radius, color, rippleAlpha, null);
            $composer.updateRememberedValue(value$iv$iv2);
        }
        $composer.endReplaceableGroup();
        CommonRippleIndicationInstance commonRippleIndicationInstance = (CommonRippleIndicationInstance) value$iv$iv2;
        $composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return commonRippleIndicationInstance;
    }

    private final ViewGroup findNearestViewGroup(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1737891121);
        ComposerKt.sourceInformation($composer, "C(findNearestViewGroup)105@4003L7:Ripple.android.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1737891121, $changed, -1, "androidx.compose.material.ripple.PlatformRipple.findNearestViewGroup (Ripple.android.kt:104)");
        }
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object view = consume;
        while (!(view instanceof ViewGroup)) {
            ViewParent parent = ((View) view).getParent();
            if (!(parent instanceof View)) {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + view + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            view = parent;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return viewGroup;
    }
}
