package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsetsPadding.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001aC\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0019\b\b\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u00122\u0019\b\u0004\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0002\b\u0012H\u0083\b¨\u0006\u0016"}, d2 = {"captionBarPadding", "Landroidx/compose/ui/Modifier;", "displayCutoutPadding", "imePadding", "mandatorySystemGesturesPadding", "navigationBarsPadding", "safeContentPadding", "safeDrawingPadding", "safeGesturesPadding", "statusBarsPadding", "systemBarsPadding", "systemGesturesPadding", "waterfallPadding", "windowInsetsPadding", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "insetsCalculation", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "Landroidx/compose/foundation/layout/WindowInsets;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WindowInsetsPadding_androidKt {
    public static final Modifier safeDrawingPadding(Modifier $this$safeDrawingPadding) {
        Intrinsics.checkNotNullParameter($this$safeDrawingPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("safeDrawingPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$safeDrawingPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getSafeDrawing(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier safeGesturesPadding(Modifier $this$safeGesturesPadding) {
        Intrinsics.checkNotNullParameter($this$safeGesturesPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("safeGesturesPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$safeGesturesPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getSafeGestures(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier safeContentPadding(Modifier $this$safeContentPadding) {
        Intrinsics.checkNotNullParameter($this$safeContentPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeContentPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("safeContentPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$safeContentPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeContentPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getSafeContent(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier systemBarsPadding(Modifier $this$systemBarsPadding) {
        Intrinsics.checkNotNullParameter($this$systemBarsPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("systemBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$systemBarsPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getSystemBars(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier displayCutoutPadding(Modifier $this$displayCutoutPadding) {
        Intrinsics.checkNotNullParameter($this$displayCutoutPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("displayCutoutPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$displayCutoutPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getDisplayCutout(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier statusBarsPadding(Modifier $this$statusBarsPadding) {
        Intrinsics.checkNotNullParameter($this$statusBarsPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("statusBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$statusBarsPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getStatusBars(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier imePadding(Modifier $this$imePadding) {
        Intrinsics.checkNotNullParameter($this$imePadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$imePadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("imePadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$imePadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$imePadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getIme(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier navigationBarsPadding(Modifier $this$navigationBarsPadding) {
        Intrinsics.checkNotNullParameter($this$navigationBarsPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("navigationBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$navigationBarsPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getNavigationBars(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier captionBarPadding(Modifier $this$captionBarPadding) {
        Intrinsics.checkNotNullParameter($this$captionBarPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$captionBarPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("captionBarPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$captionBarPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$captionBarPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getCaptionBar(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier waterfallPadding(Modifier $this$waterfallPadding) {
        Intrinsics.checkNotNullParameter($this$waterfallPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$waterfallPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("waterfallPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$waterfallPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$waterfallPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getWaterfall(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier systemGesturesPadding(Modifier $this$systemGesturesPadding) {
        Intrinsics.checkNotNullParameter($this$systemGesturesPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("systemGesturesPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$systemGesturesPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getSystemGestures(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    public static final Modifier mandatorySystemGesturesPadding(Modifier $this$mandatorySystemGesturesPadding) {
        Intrinsics.checkNotNullParameter($this$mandatorySystemGesturesPadding, "<this>");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("mandatorySystemGesturesPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return ComposedModifierKt.composed($this$mandatorySystemGesturesPadding, inspectorInfo$iv, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$windowInsetsPadding$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(current.getMandatorySystemGestures(), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }

    private static final Modifier windowInsetsPadding(Modifier $this$windowInsetsPadding, Function1<? super InspectorInfo, Unit> function1, final Function1<? super WindowInsetsHolder, ? extends WindowInsets> function12) {
        return ComposedModifierKt.composed($this$windowInsetsPadding, function1, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$windowInsetsPadding$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object insetsPaddingModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(359872873);
                ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.INSTANCE.current(composer, 8);
                Function1<WindowInsetsHolder, WindowInsets> function13 = function12;
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    insetsPaddingModifier = new InsetsPaddingModifier(function13.invoke(current), null, 2, 0 == true ? 1 : 0);
                    composer.updateRememberedValue(insetsPaddingModifier);
                } else {
                    insetsPaddingModifier = rememberedValue;
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier2 = (InsetsPaddingModifier) insetsPaddingModifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier2;
            }
        });
    }
}
