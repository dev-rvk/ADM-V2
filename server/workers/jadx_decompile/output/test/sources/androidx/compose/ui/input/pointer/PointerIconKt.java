package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerIcon.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ModifierLocalPointerIcon", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/input/pointer/PointerIconModifierLocal;", "pointerHoverIcon", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PointerIconKt {
    private static final ProvidableModifierLocal<PointerIconModifierLocal> ModifierLocalPointerIcon = ModifierLocalKt.modifierLocalOf(new Function0<PointerIconModifierLocal>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$ModifierLocalPointerIcon$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PointerIconModifierLocal invoke() {
            return null;
        }
    });

    public static /* synthetic */ Modifier pointerHoverIcon$default(Modifier modifier, PointerIcon pointerIcon, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pointerHoverIcon(modifier, pointerIcon, z);
    }

    public static final Modifier pointerHoverIcon(Modifier $this$pointerHoverIcon, final PointerIcon icon, final boolean overrideDescendants) {
        Intrinsics.checkNotNullParameter($this$pointerHoverIcon, "<this>");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return ComposedModifierKt.composed($this$pointerHoverIcon, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("pointerHoverIcon");
                $this$null.getProperties().set("icon", PointerIcon.this);
                $this$null.getProperties().set("overrideDescendants", Boolean.valueOf(overrideDescendants));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Object value$iv$iv2;
                Modifier.Companion pointerInputModifier;
                Modifier.Companion then;
                Object value$iv$iv3;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(811087536);
                ComposerKt.sourceInformation($composer, "C90@3499L7,97@3759L103,100@3886L226,100@3875L237,108@4265L525:PointerIcon.kt#a556rk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(811087536, $changed, -1, "androidx.compose.ui.input.pointer.pointerHoverIcon.<anonymous> (PointerIcon.kt:89)");
                }
                ProvidableCompositionLocal<PointerIconService> localPointerIconService = CompositionLocalsKt.getLocalPointerIconService();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localPointerIconService);
                ComposerKt.sourceInformationMarkerEnd($composer);
                final PointerIconService pointerIconService = (PointerIconService) consume;
                if (pointerIconService == null) {
                    then = Modifier.INSTANCE;
                } else {
                    final Function1 onSetIcon = new Function1<PointerIcon, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$onSetIcon$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PointerIcon pointerIcon) {
                            invoke2(pointerIcon);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PointerIcon pointerIcon) {
                            PointerIconService.this.setIcon(pointerIcon);
                        }
                    };
                    PointerIcon pointerIcon = PointerIcon.this;
                    boolean z = overrideDescendants;
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new PointerIconModifierLocal(pointerIcon, z, onSetIcon);
                        $composer.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer.endReplaceableGroup();
                    final PointerIconModifierLocal pointerIconModifierLocal = (PointerIconModifierLocal) value$iv$iv;
                    Object[] keys$iv = {pointerIconModifierLocal, PointerIcon.this, Boolean.valueOf(overrideDescendants), onSetIcon};
                    final PointerIcon pointerIcon2 = PointerIcon.this;
                    final boolean z2 = overrideDescendants;
                    $composer.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv = false;
                    for (Object key$iv : keys$iv) {
                        invalid$iv |= $composer.changed(key$iv);
                    }
                    Object it$iv$iv2 = $composer.rememberedValue();
                    if (invalid$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                PointerIconModifierLocal.this.updateValues(pointerIcon2, z2, onSetIcon);
                            }
                        };
                        $composer.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv2;
                    }
                    $composer.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) value$iv$iv2, $composer, 0);
                    if (!pointerIconModifierLocal.shouldUpdatePointerIcon()) {
                        pointerInputModifier = Modifier.INSTANCE;
                    } else {
                        $composer.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv = $composer.changed(pointerIconModifierLocal);
                        Object it$iv$iv3 = $composer.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv3 = new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(pointerIconModifierLocal, null);
                            $composer.updateRememberedValue(value$iv$iv3);
                        } else {
                            value$iv$iv3 = it$iv$iv3;
                        }
                        $composer.endReplaceableGroup();
                        pointerInputModifier = SuspendingPointerInputFilterKt.pointerInput(composed, pointerIconModifierLocal, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv3);
                    }
                    then = pointerIconModifierLocal.then(pointerInputModifier);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return then;
            }
        });
    }
}
