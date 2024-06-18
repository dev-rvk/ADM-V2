package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TimePickerKt$clockDial$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $autoSwitchToMinute;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$clockDial$2(TimePickerState timePickerState, boolean z) {
        super(3);
        this.$state = timePickerState;
        this.$autoSwitchToMinute = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$1(MutableState<Float> mutableState) {
        MutableState<Float> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Float> mutableState, float value) {
        mutableState.setValue(Float.valueOf(value));
    }

    public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv$iv;
        float f;
        Object value$iv$iv4;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        $composer.startReplaceableGroup(-1645090088);
        ComposerKt.sourceInformation($composer, "C1245@47844L31,1246@47895L31,1247@47945L43,1248@48005L24,*1249@48066L7,1252@48143L28:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1645090088, $changed, -1, "androidx.compose.material3.clockDial.<anonymous> (TimePicker.kt:1244)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState offsetX$delegate = (MutableState) value$iv$iv;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        MutableState offsetY$delegate = (MutableState) value$iv$iv2;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv3 = $composer.rememberedValue();
        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m5327boximpl(IntOffset.INSTANCE.m5346getZeronOccac()), null, 2, null);
            $composer.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        MutableState center$delegate = (MutableState) value$iv$iv3;
        $composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv$iv = $composer.rememberedValue();
        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        CoroutineScope scope = wrapper$iv.getCoroutineScope();
        $composer.endReplaceableGroup();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$invoke_u24lambda_u248 = (Density) consume;
        f = TimePickerKt.MaxDistance;
        float maxDist = $this$invoke_u24lambda_u248.mo329toPx0680j_4(f);
        Modifier.Companion companion = Modifier.INSTANCE;
        Object key1$iv = this.$state;
        final TimePickerState timePickerState = this.$state;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv);
        Object it$iv$iv4 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv4 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.TimePickerKt$clockDial$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                    m1898invokeozmzZPI(intSize.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                public final void m1898invokeozmzZPI(long it) {
                    TimePickerState.this.m1914setCentergyyYBs$material3_release(IntSizeKt.m5384getCenterozmzZPI(it));
                }
            };
            $composer.updateRememberedValue(value$iv$iv4);
        } else {
            value$iv$iv4 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) value$iv$iv4), new Object[]{this.$state, IntOffset.m5327boximpl(invoke$lambda$7(center$delegate)), Float.valueOf(maxDist)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass2(offsetX$delegate, offsetY$delegate, scope, this.$state, maxDist, this.$autoSwitchToMinute, null)), new Object[]{this.$state, IntOffset.m5327boximpl(invoke$lambda$7(center$delegate)), Float.valueOf(maxDist)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass3(scope, this.$state, this.$autoSwitchToMinute, maxDist, offsetX$delegate, offsetY$delegate, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return pointerInput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$4(MutableState<Float> mutableState) {
        MutableState<Float> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$5(MutableState<Float> mutableState, float value) {
        mutableState.setValue(Float.valueOf(value));
    }

    private static final long invoke$lambda$7(MutableState<IntOffset> mutableState) {
        MutableState<IntOffset> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePicker.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2", f = "TimePicker.kt", i = {}, l = {1255}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ float $maxDist;
        final /* synthetic */ MutableState<Float> $offsetX$delegate;
        final /* synthetic */ MutableState<Float> $offsetY$delegate;
        final /* synthetic */ CoroutineScope $scope;
        final /* synthetic */ TimePickerState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableState<Float> mutableState, MutableState<Float> mutableState2, CoroutineScope coroutineScope, TimePickerState timePickerState, float f, boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$offsetX$delegate = mutableState;
            this.$offsetY$delegate = mutableState2;
            this.$scope = coroutineScope;
            this.$state = timePickerState;
            this.$maxDist = f;
            this.$autoSwitchToMinute = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$offsetX$delegate, this.$offsetY$delegate, this.$scope, this.$state, this.$maxDist, this.$autoSwitchToMinute, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TimePicker.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2$1", f = "TimePicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableState<Float> $offsetX$delegate;
            final /* synthetic */ MutableState<Float> $offsetY$delegate;
            /* synthetic */ long J$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MutableState<Float> mutableState, MutableState<Float> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
                this.$offsetX$delegate = mutableState;
                this.$offsetY$delegate = mutableState2;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                return m1899invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
            }

            /* renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m1899invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$offsetX$delegate, this.$offsetY$delegate, continuation);
                anonymousClass1.J$0 = j;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        long it = this.J$0;
                        TimePickerKt$clockDial$2.invoke$lambda$2(this.$offsetX$delegate, Offset.m2710getXimpl(it));
                        TimePickerKt$clockDial$2.invoke$lambda$5(this.$offsetY$delegate, Offset.m2711getYimpl(it));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object detectTapGestures;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$offsetX$delegate, this.$offsetY$delegate, null);
                    final CoroutineScope coroutineScope = this.$scope;
                    final TimePickerState timePickerState = this.$state;
                    final float f = this.$maxDist;
                    final boolean z = this.$autoSwitchToMinute;
                    Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m1900invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m1900invokek4lQ0M(long it) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(timePickerState, it, f, z, null), 3, null);
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: TimePicker.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2$2$1", f = "TimePicker.kt", i = {}, l = {1261}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$2$1, reason: invalid class name */
                        /* loaded from: classes.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ boolean $autoSwitchToMinute;
                            final /* synthetic */ long $it;
                            final /* synthetic */ float $maxDist;
                            final /* synthetic */ TimePickerState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(TimePickerState timePickerState, long j, float f, boolean z, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$state = timePickerState;
                                this.$it = j;
                                this.$maxDist = f;
                                this.$autoSwitchToMinute = z;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$state, this.$it, this.$maxDist, this.$autoSwitchToMinute, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object $result) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        this.label = 1;
                                        if (this.$state.onTap$material3_release(Offset.m2710getXimpl(this.$it), Offset.m2711getYimpl(this.$it), this.$maxDist, this.$autoSwitchToMinute, this) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    };
                    this.label = 1;
                    detectTapGestures = TapGestureDetectorKt.detectTapGestures($this$pointerInput, (r13 & 1) != 0 ? null : null, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? TapGestureDetectorKt.NoPressGesture : anonymousClass1, (r13 & 8) != 0 ? null : function1, this);
                    if (detectTapGestures != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePicker.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3", f = "TimePicker.kt", i = {}, l = {1266}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ float $maxDist;
        final /* synthetic */ MutableState<Float> $offsetX$delegate;
        final /* synthetic */ MutableState<Float> $offsetY$delegate;
        final /* synthetic */ CoroutineScope $scope;
        final /* synthetic */ TimePickerState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(CoroutineScope coroutineScope, TimePickerState timePickerState, boolean z, float f, MutableState<Float> mutableState, MutableState<Float> mutableState2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$scope = coroutineScope;
            this.$state = timePickerState;
            this.$autoSwitchToMinute = z;
            this.$maxDist = f;
            this.$offsetX$delegate = mutableState;
            this.$offsetY$delegate = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$scope, this.$state, this.$autoSwitchToMinute, this.$maxDist, this.$offsetX$delegate, this.$offsetY$delegate, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object detectDragGestures;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    final CoroutineScope coroutineScope = this.$scope;
                    final TimePickerState timePickerState = this.$state;
                    final boolean z = this.$autoSwitchToMinute;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C00591(timePickerState, z, null), 3, null);
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: TimePicker.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3$1$1", f = "TimePicker.kt", i = {}, l = {1270, 1272}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes.dex */
                        public static final class C00591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ boolean $autoSwitchToMinute;
                            final /* synthetic */ TimePickerState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00591(TimePickerState timePickerState, boolean z, Continuation<? super C00591> continuation) {
                                super(2, continuation);
                                this.$state = timePickerState;
                                this.$autoSwitchToMinute = z;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00591(this.$state, this.$autoSwitchToMinute, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object $result) {
                                C00591 c00591;
                                C00591 c005912;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        if (Selection.m1695equalsimpl0(this.$state.m1912getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1699getHourJiIwxys()) && this.$autoSwitchToMinute) {
                                            this.$state.m1915setSelectioniHAOin8$material3_release(Selection.INSTANCE.m1700getMinuteJiIwxys());
                                            this.label = 1;
                                            if (this.$state.animateToCurrent$material3_release(this) != coroutine_suspended) {
                                                c005912 = this;
                                                return Unit.INSTANCE;
                                            }
                                            return coroutine_suspended;
                                        }
                                        if (Selection.m1695equalsimpl0(this.$state.m1912getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1700getMinuteJiIwxys())) {
                                            this.label = 2;
                                            if (this.$state.settle(this) != coroutine_suspended) {
                                                c00591 = this;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    case 1:
                                        c005912 = this;
                                        ResultKt.throwOnFailure($result);
                                        return Unit.INSTANCE;
                                    case 2:
                                        c00591 = this;
                                        ResultKt.throwOnFailure($result);
                                        return Unit.INSTANCE;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }
                    };
                    final CoroutineScope coroutineScope2 = this.$scope;
                    final TimePickerState timePickerState2 = this.$state;
                    final float f = this.$maxDist;
                    final MutableState<Float> mutableState = this.$offsetX$delegate;
                    final MutableState<Float> mutableState2 = this.$offsetY$delegate;
                    this.label = 1;
                    detectDragGestures = DragGestureDetectorKt.detectDragGestures($this$pointerInput, (r12 & 1) != 0 ? new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m283invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m283invokek4lQ0M(long it) {
                        }
                    } : null, (r12 & 2) != 0 ? new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$3
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    } : function0, (r12 & 4) != 0 ? new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$4
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    } : null, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.3.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                            m1901invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m1901invokeUv8p0NA(PointerInputChange pointerInputChange, long dragAmount) {
                            Intrinsics.checkNotNullParameter(pointerInputChange, "<anonymous parameter 0>");
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(dragAmount, timePickerState2, mutableState, mutableState2, null), 3, null);
                            timePickerState2.moveSelector$material3_release(TimePickerKt$clockDial$2.invoke$lambda$1(mutableState), TimePickerKt$clockDial$2.invoke$lambda$4(mutableState2), f);
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: TimePicker.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3$2$1", f = "TimePicker.kt", i = {}, l = {1279}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$2$1, reason: invalid class name */
                        /* loaded from: classes.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ long $dragAmount;
                            final /* synthetic */ MutableState<Float> $offsetX$delegate;
                            final /* synthetic */ MutableState<Float> $offsetY$delegate;
                            final /* synthetic */ TimePickerState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(long j, TimePickerState timePickerState, MutableState<Float> mutableState, MutableState<Float> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$dragAmount = j;
                                this.$state = timePickerState;
                                this.$offsetX$delegate = mutableState;
                                this.$offsetY$delegate = mutableState2;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$dragAmount, this.$state, this.$offsetX$delegate, this.$offsetY$delegate, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object $result) {
                                float atan;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        TimePickerKt$clockDial$2.invoke$lambda$2(this.$offsetX$delegate, TimePickerKt$clockDial$2.invoke$lambda$1(this.$offsetX$delegate) + Offset.m2710getXimpl(this.$dragAmount));
                                        TimePickerKt$clockDial$2.invoke$lambda$5(this.$offsetY$delegate, TimePickerKt$clockDial$2.invoke$lambda$4(this.$offsetY$delegate) + Offset.m2711getYimpl(this.$dragAmount));
                                        TimePickerState timePickerState = this.$state;
                                        atan = TimePickerKt.atan(TimePickerKt$clockDial$2.invoke$lambda$4(this.$offsetY$delegate) - IntOffset.m5337getYimpl(this.$state.m1911getCenternOccac$material3_release()), TimePickerKt$clockDial$2.invoke$lambda$1(this.$offsetX$delegate) - IntOffset.m5336getXimpl(this.$state.m1911getCenternOccac$material3_release()));
                                        this.label = 1;
                                        if (TimePickerState.update$material3_release$default(timePickerState, atan, false, this, 2, null) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }, this);
                    if (detectDragGestures != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
