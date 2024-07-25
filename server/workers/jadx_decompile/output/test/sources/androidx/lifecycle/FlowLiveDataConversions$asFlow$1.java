package androidx.lifecycle;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowLiveData.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 1}, l = {107, 112, 114}, m = "invokeSuspend", n = {"observer", "observer"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
final class FlowLiveDataConversions$asFlow$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveData<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(LiveData<T> liveData, Continuation<? super FlowLiveDataConversions$asFlow$1> continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, continuation);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((FlowLiveDataConversions$asFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[RETURN] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            switch(r1) {
                case 0: goto L30;
                case 1: goto L27;
                case 2: goto L1c;
                case 3: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L12:
            r0 = r8
            java.lang.Object r1 = r0.L$0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L9f
        L1c:
            r1 = r8
            java.lang.Object r3 = r1.L$0
            androidx.lifecycle.Observer r3 = (androidx.lifecycle.Observer) r3
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L25
            goto L6f
        L25:
            r4 = move-exception
            goto L75
        L27:
            r1 = r8
            java.lang.Object r3 = r1.L$0
            androidx.lifecycle.Observer r3 = (androidx.lifecycle.Observer) r3
            kotlin.ResultKt.throwOnFailure(r9)
            goto L60
        L30:
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r8
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r3 = (kotlinx.coroutines.channels.ProducerScope) r3
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0 r4 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0
            r4.<init>()
            r3 = r4
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r4 = r4.getImmediate()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r5 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
            androidx.lifecycle.LiveData<T> r6 = r1.$this_asFlow
            r5.<init>(r6, r3, r2)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.L$0 = r3
            r7 = 1
            r1.label = r7
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r6)
            if (r4 != r0) goto L60
            return r0
        L60:
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Throwable -> L25
            r1.L$0 = r3     // Catch: java.lang.Throwable -> L25
            r5 = 2
            r1.label = r5     // Catch: java.lang.Throwable -> L25
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.awaitCancellation(r4)     // Catch: java.lang.Throwable -> L25
            if (r4 != r0) goto L6f
            return r0
        L6f:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L25
            r4.<init>()     // Catch: java.lang.Throwable -> L25
            throw r4     // Catch: java.lang.Throwable -> L25
        L75:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r5 = r5.getImmediate()
            kotlinx.coroutines.NonCancellable r6 = kotlinx.coroutines.NonCancellable.INSTANCE
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            kotlin.coroutines.CoroutineContext r5 = r5.plus(r6)
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r6 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
            androidx.lifecycle.LiveData<T> r7 = r1.$this_asFlow
            r6.<init>(r7, r3, r2)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r2 = r1
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r1.L$0 = r4
            r7 = 3
            r1.label = r7
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r2)
            if (r2 != r0) goto L9d
            return r0
        L9d:
            r0 = r1
            r1 = r4
        L9f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowLiveData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Observer<T> $observer;
        final /* synthetic */ LiveData<T> $this_asFlow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LiveData<T> liveData, Observer<T> observer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_asFlow, this.$observer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.$this_asFlow.observeForever(this.$observer);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowLiveData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Observer<T> $observer;
        final /* synthetic */ LiveData<T> $this_asFlow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LiveData<T> liveData, Observer<T> observer, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_asFlow, this.$observer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.$this_asFlow.removeObserver(this.$observer);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
