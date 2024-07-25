package androidx.compose.foundation.gestures;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a6\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0007\u001a&\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"detectZoom", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "Landroidx/compose/runtime/State;", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TransformableKt {
    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier $this$transformable, TransformableState state, boolean lockRotationOnZoomPan, boolean enabled) {
        Intrinsics.checkNotNullParameter($this$transformable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return transformable($this$transformable, state, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return true;
            }
        }, lockRotationOnZoomPan, enabled);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function0 function0, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function0, z, z2);
    }

    public static final Modifier transformable(Modifier $this$transformable, final TransformableState state, final Function0<Boolean> canPan, final boolean lockRotationOnZoomPan, final boolean enabled) {
        Intrinsics.checkNotNullParameter($this$transformable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(canPan, "canPan");
        return ComposedModifierKt.composed($this$transformable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$$inlined$debugInspectorInfo$1
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
                $this$null.setName("transformable");
                $this$null.getProperties().set("state", TransformableState.this);
                $this$null.getProperties().set("canPan", canPan);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("lockRotationOnZoomPan", Boolean.valueOf(lockRotationOnZoomPan));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$3
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
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(298661433);
                ComposerKt.sourceInformation($composer, "C98@4744L43,99@4816L28,100@4867L66,121@5860L524:Transformable.kt#8bwon0");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(298661433, $changed, -1, "androidx.compose.foundation.gestures.transformable.<anonymous> (Transformable.kt:97)");
                }
                State updatePanZoomLock = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(lockRotationOnZoomPan), $composer, 0);
                State updatedCanPan = SnapshotStateKt.rememberUpdatedState(canPan, $composer, 0);
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                Channel channel = (Channel) value$iv$iv;
                $composer.startReplaceableGroup(-2015615917);
                ComposerKt.sourceInformation($composer, "102@4969L822");
                if (enabled) {
                    EffectsKt.LaunchedEffect(state, new AnonymousClass1(channel, state, null), $composer, 64);
                }
                $composer.endReplaceableGroup();
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv2 = $composer.rememberedValue();
                if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = new TransformableKt$transformable$3$block$1$1(updatePanZoomLock, channel, updatedCanPan, null);
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer.endReplaceableGroup();
                Function2 block = (Function2) value$iv$iv2;
                Modifier.Companion pointerInput = enabled ? SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, channel, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) block) : Modifier.INSTANCE;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return pointerInput;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Transformable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$1", f = "Transformable.kt", i = {0, 0, 1}, l = {105, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", n = {"$this$LaunchedEffect", NotificationCompat.CATEGORY_EVENT, "$this$LaunchedEffect"}, s = {"L$0", "L$1", "L$0"})
            /* renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Channel<TransformEvent> $channel;
                final /* synthetic */ TransformableState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Channel<TransformEvent> channel, TransformableState transformableState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$channel = channel;
                    this.$state = transformableState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$channel, this.$state, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: Transformable.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1", f = "Transformable.kt", i = {0}, l = {113}, m = "invokeSuspend", n = {"$this$transform"}, s = {"L$0"})
                /* renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00091 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Channel<TransformEvent> $channel;
                    final /* synthetic */ Ref.ObjectRef<TransformEvent> $event;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00091(Ref.ObjectRef<TransformEvent> objectRef, Channel<TransformEvent> channel, Continuation<? super C00091> continuation) {
                        super(2, continuation);
                        this.$event = objectRef;
                        this.$channel = channel;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00091 c00091 = new C00091(this.$event, this.$channel, continuation);
                        c00091.L$0 = obj;
                        return c00091;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
                        return ((C00091) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
                    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0069 -> B:7:0x0070). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                        /*
                            r10 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r10.label
                            switch(r1) {
                                case 0: goto L23;
                                case 1: goto L11;
                                default: goto L9;
                            }
                        L9:
                            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r11.<init>(r0)
                            throw r11
                        L11:
                            r1 = r10
                            java.lang.Object r2 = r1.L$1
                            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                            java.lang.Object r3 = r1.L$0
                            androidx.compose.foundation.gestures.TransformScope r3 = (androidx.compose.foundation.gestures.TransformScope) r3
                            kotlin.ResultKt.throwOnFailure(r11)
                            r4 = r3
                            r3 = r2
                            r2 = r1
                            r1 = r0
                            r0 = r11
                            goto L70
                        L23:
                            kotlin.ResultKt.throwOnFailure(r11)
                            r1 = r10
                            java.lang.Object r2 = r1.L$0
                            androidx.compose.foundation.gestures.TransformScope r2 = (androidx.compose.foundation.gestures.TransformScope) r2
                            r3 = r2
                        L2c:
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r2 = r1.$event
                            T r2 = r2.element
                            boolean r2 = r2 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStopped
                            if (r2 != 0) goto L77
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r2 = r1.$event
                            T r2 = r2.element
                            boolean r4 = r2 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformDelta
                            if (r4 == 0) goto L3f
                            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r2 = (androidx.compose.foundation.gestures.TransformEvent.TransformDelta) r2
                            goto L40
                        L3f:
                            r2 = 0
                        L40:
                            if (r2 == 0) goto L54
                            r4 = 0
                            float r5 = r2.getZoomChange()
                            long r6 = r2.getPanChange()
                            float r8 = r2.getRotationChange()
                            r3.mo255transformByd4ec7I(r5, r6, r8)
                        L54:
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r2 = r1.$event
                            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r4 = r1.$channel
                            r5 = r1
                            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                            r1.L$0 = r3
                            r1.L$1 = r2
                            r6 = 1
                            r1.label = r6
                            java.lang.Object r4 = r4.receive(r5)
                            if (r4 != r0) goto L69
                            return r0
                        L69:
                            r9 = r0
                            r0 = r11
                            r11 = r4
                            r4 = r3
                            r3 = r2
                            r2 = r1
                            r1 = r9
                        L70:
                            r3.element = r11
                            r11 = r0
                            r0 = r1
                            r1 = r2
                            r3 = r4
                            goto L2c
                        L77:
                            kotlin.Unit r0 = kotlin.Unit.INSTANCE
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt$transformable$3.AnonymousClass1.C00091.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
                /* JADX WARN: Removed duplicated region for block: B:18:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0097 -> B:9:0x003b). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008c -> B:9:0x003b). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0092 -> B:9:0x003b). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        switch(r1) {
                            case 0: goto L33;
                            case 1: goto L1d;
                            case 2: goto L11;
                            default: goto L9;
                        }
                    L9:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L11:
                        r1 = r10
                        java.lang.Object r2 = r1.L$0
                        kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                        kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> L1b
                        goto L90
                    L1b:
                        r3 = move-exception
                        goto L3b
                    L1d:
                        r1 = r10
                        java.lang.Object r2 = r1.L$2
                        kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                        java.lang.Object r3 = r1.L$1
                        kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                        java.lang.Object r4 = r1.L$0
                        kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                        kotlin.ResultKt.throwOnFailure(r11)
                        r5 = r3
                        r3 = r2
                        r2 = r1
                        r1 = r0
                        r0 = r11
                        goto L62
                    L33:
                        kotlin.ResultKt.throwOnFailure(r11)
                        r1 = r10
                        java.lang.Object r2 = r1.L$0
                        kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                    L3b:
                        boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r2)
                        if (r3 == 0) goto L9c
                        kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
                        r3.<init>()
                        kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r4 = r1.$channel
                        r5 = r1
                        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                        r1.L$0 = r2
                        r1.L$1 = r3
                        r1.L$2 = r3
                        r6 = 1
                        r1.label = r6
                        java.lang.Object r4 = r4.receive(r5)
                        if (r4 != r0) goto L5b
                        return r0
                    L5b:
                        r5 = r3
                        r9 = r0
                        r0 = r11
                        r11 = r4
                        r4 = r2
                        r2 = r1
                        r1 = r9
                    L62:
                        r3.element = r11
                        T r11 = r5.element
                        boolean r11 = r11 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStarted
                        if (r11 == 0) goto L97
                    L6b:
                        androidx.compose.foundation.gestures.TransformableState r11 = r2.$state     // Catch: java.util.concurrent.CancellationException -> L91
                        androidx.compose.foundation.MutatePriority r3 = androidx.compose.foundation.MutatePriority.UserInput     // Catch: java.util.concurrent.CancellationException -> L91
                        androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1 r6 = new androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1     // Catch: java.util.concurrent.CancellationException -> L91
                        kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r7 = r2.$channel     // Catch: java.util.concurrent.CancellationException -> L91
                        r8 = 0
                        r6.<init>(r5, r7, r8)     // Catch: java.util.concurrent.CancellationException -> L91
                        kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.util.concurrent.CancellationException -> L91
                        r7 = r2
                        kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.util.concurrent.CancellationException -> L91
                        r2.L$0 = r4     // Catch: java.util.concurrent.CancellationException -> L91
                        r2.L$1 = r8     // Catch: java.util.concurrent.CancellationException -> L91
                        r2.L$2 = r8     // Catch: java.util.concurrent.CancellationException -> L91
                        r8 = 2
                        r2.label = r8     // Catch: java.util.concurrent.CancellationException -> L91
                        java.lang.Object r11 = r11.transform(r3, r6, r7)     // Catch: java.util.concurrent.CancellationException -> L91
                        if (r11 != r1) goto L8c
                        return r1
                    L8c:
                        r11 = r0
                        r0 = r1
                        r1 = r2
                        r2 = r4
                    L90:
                        goto L3b
                    L91:
                        r11 = move-exception
                        r11 = r0
                        r0 = r1
                        r1 = r2
                        r2 = r4
                        goto L3b
                    L97:
                        r11 = r0
                        r0 = r1
                        r1 = r2
                        r2 = r4
                        goto L3b
                    L9c:
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt$transformable$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0232, code lost:
    
        if (r14.getValue().invoke().booleanValue() != false) goto L74;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0024. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x033a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0303 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x02ba -> B:12:0x02ce). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r28, androidx.compose.runtime.State<java.lang.Boolean> r29, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r30, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function0<java.lang.Boolean>> r31, kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, kotlinx.coroutines.channels.Channel, androidx.compose.runtime.State, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
