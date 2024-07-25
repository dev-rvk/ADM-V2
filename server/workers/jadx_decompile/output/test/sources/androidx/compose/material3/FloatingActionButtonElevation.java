package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B*\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\rJ \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\rR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class FloatingActionButtonElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ FloatingActionButtonElevation(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private FloatingActionButtonElevation(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation) {
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.focusedElevation = focusedElevation;
        this.hoveredElevation = hoveredElevation;
    }

    public final State<Dp> shadowElevation$material3_release(InteractionSource interactionSource, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-424810125);
        ComposerKt.sourceInformation($composer, "C(shadowElevation)496@24108L55:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-424810125, $changed, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:495)");
        }
        State<Dp> animateElevation = animateElevation(interactionSource, $composer, ($changed & 14) | ($changed & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateElevation;
    }

    public final State<Dp> tonalElevation$material3_release(InteractionSource interactionSource, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-550096911);
        ComposerKt.sourceInformation($composer, "C(tonalElevation)501@24285L55:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-550096911, $changed, -1, "androidx.compose.material3.FloatingActionButtonElevation.tonalElevation (FloatingActionButton.kt:500)");
        }
        State<Dp> animateElevation = animateElevation(interactionSource, $composer, ($changed & 14) | ($changed & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateElevation;
    }

    private final State<Dp> animateElevation(InteractionSource interactionSource, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        float target;
        Object value$iv$iv3;
        $composer.startReplaceableGroup(-1845106002);
        ComposerKt.sourceInformation($composer, "C(animateElevation)506@24475L46,508@24565L1077,508@24531L1111,545@25986L51,547@26047L499:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1845106002, $changed, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:505)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt.mutableStateListOf();
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapshotStateList interactions = (SnapshotStateList) value$iv$iv;
        int i = ($changed & 14) | 48;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(interactionSource) | $composer.changed(interactions);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = new FloatingActionButtonElevation$animateElevation$1$1(interactionSource, interactions, null);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv2, $composer, ($changed & 14) | 64);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) interactions);
        if (interaction instanceof PressInteraction.Press) {
            target = this.pressedElevation;
        } else if (interaction instanceof HoverInteraction.Enter) {
            target = this.hoveredElevation;
        } else {
            target = interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv3 = $composer.rememberedValue();
        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv3 = new Animatable(Dp.m5216boximpl(target), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), null, null, 12, null);
            $composer.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        Animatable animatable = (Animatable) value$iv$iv3;
        EffectsKt.LaunchedEffect(Dp.m5216boximpl(target), new FloatingActionButtonElevation$animateElevation$2(animatable, this, target, interaction, null), $composer, 64);
        State<Dp> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof FloatingActionButtonElevation) && Dp.m5223equalsimpl0(this.defaultElevation, ((FloatingActionButtonElevation) other).defaultElevation) && Dp.m5223equalsimpl0(this.pressedElevation, ((FloatingActionButtonElevation) other).pressedElevation) && Dp.m5223equalsimpl0(this.focusedElevation, ((FloatingActionButtonElevation) other).focusedElevation) && Dp.m5223equalsimpl0(this.hoveredElevation, ((FloatingActionButtonElevation) other).hoveredElevation)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Dp.m5224hashCodeimpl(this.defaultElevation);
        return (((((result * 31) + Dp.m5224hashCodeimpl(this.pressedElevation)) * 31) + Dp.m5224hashCodeimpl(this.focusedElevation)) * 31) + Dp.m5224hashCodeimpl(this.hoveredElevation);
    }
}
