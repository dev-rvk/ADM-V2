package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: MappedInteractionSource.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002R\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/MappedInteractionSource;", "Landroidx/compose/foundation/interaction/InteractionSource;", "underlyingInteractionSource", "delta", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/foundation/interaction/InteractionSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "interactions", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/foundation/interaction/Interaction;", "getInteractions", "()Lkotlinx/coroutines/flow/Flow;", "mappedPresses", "", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "mapPress", "press", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MappedInteractionSource implements InteractionSource {
    private final long delta;
    private final Flow<Interaction> interactions;
    private final Map<PressInteraction.Press, PressInteraction.Press> mappedPresses;

    public /* synthetic */ MappedInteractionSource(InteractionSource interactionSource, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, j);
    }

    private MappedInteractionSource(InteractionSource underlyingInteractionSource, long delta) {
        Intrinsics.checkNotNullParameter(underlyingInteractionSource, "underlyingInteractionSource");
        this.delta = delta;
        this.mappedPresses = new LinkedHashMap();
        final Flow $this$map$iv = underlyingInteractionSource.getInteractions();
        this.interactions = new Flow<Interaction>() { // from class: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* renamed from: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ MappedInteractionSource this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2", f = "MappedInteractionSource.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, MappedInteractionSource mappedInteractionSource) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = mappedInteractionSource;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r10
                        androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = (androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r10 = r0.label
                        int r10 = r10 - r2
                        r0.label = r10
                        goto L19
                    L14:
                        androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = new androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L19:
                        r10 = r0
                        java.lang.Object r0 = r10.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r10.label
                        switch(r2) {
                            case 0: goto L33;
                            case 1: goto L2d;
                            default: goto L25;
                        }
                    L25:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L2d:
                        r9 = 0
                        kotlin.ResultKt.throwOnFailure(r0)
                        goto Lb7
                    L33:
                        kotlin.ResultKt.throwOnFailure(r0)
                        r2 = r8
                        kotlinx.coroutines.flow.FlowCollector r3 = r2.$this_unsafeFlow
                        r4 = 0
                        r5 = r10
                        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                        androidx.compose.foundation.interaction.Interaction r9 = (androidx.compose.foundation.interaction.Interaction) r9
                        r5 = 0
                        boolean r6 = r9 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
                        if (r6 == 0) goto L5c
                        androidx.compose.material3.MappedInteractionSource r6 = r2.this$0
                        r7 = r9
                        androidx.compose.foundation.interaction.PressInteraction$Press r7 = (androidx.compose.foundation.interaction.PressInteraction.Press) r7
                        androidx.compose.foundation.interaction.PressInteraction$Press r6 = androidx.compose.material3.MappedInteractionSource.access$mapPress(r6, r7)
                        androidx.compose.material3.MappedInteractionSource r7 = r2.this$0
                        java.util.Map r7 = androidx.compose.material3.MappedInteractionSource.access$getMappedPresses$p(r7)
                        r7.put(r9, r6)
                        r9 = r6
                        androidx.compose.foundation.interaction.Interaction r9 = (androidx.compose.foundation.interaction.Interaction) r9
                        goto Lab
                    L5c:
                        boolean r6 = r9 instanceof androidx.compose.foundation.interaction.PressInteraction.Cancel
                        if (r6 == 0) goto L83
                        androidx.compose.material3.MappedInteractionSource r6 = r2.this$0
                        java.util.Map r6 = androidx.compose.material3.MappedInteractionSource.access$getMappedPresses$p(r6)
                        r7 = r9
                        androidx.compose.foundation.interaction.PressInteraction$Cancel r7 = (androidx.compose.foundation.interaction.PressInteraction.Cancel) r7
                        androidx.compose.foundation.interaction.PressInteraction$Press r7 = r7.getPress()
                        java.lang.Object r6 = r6.remove(r7)
                        r2 = r6
                        androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                        if (r2 != 0) goto L7a
                        r6 = r9
                        androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = (androidx.compose.foundation.interaction.PressInteraction.Cancel) r6
                        goto L7f
                    L7a:
                        androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                        r6.<init>(r2)
                    L7f:
                        r9 = r6
                        androidx.compose.foundation.interaction.Interaction r9 = (androidx.compose.foundation.interaction.Interaction) r9
                        goto Lab
                    L83:
                        boolean r6 = r9 instanceof androidx.compose.foundation.interaction.PressInteraction.Release
                        if (r6 == 0) goto Laa
                        androidx.compose.material3.MappedInteractionSource r6 = r2.this$0
                        java.util.Map r6 = androidx.compose.material3.MappedInteractionSource.access$getMappedPresses$p(r6)
                        r7 = r9
                        androidx.compose.foundation.interaction.PressInteraction$Release r7 = (androidx.compose.foundation.interaction.PressInteraction.Release) r7
                        androidx.compose.foundation.interaction.PressInteraction$Press r7 = r7.getPress()
                        java.lang.Object r6 = r6.remove(r7)
                        r2 = r6
                        androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                        if (r2 != 0) goto La1
                        r6 = r9
                        androidx.compose.foundation.interaction.PressInteraction$Release r6 = (androidx.compose.foundation.interaction.PressInteraction.Release) r6
                        goto La6
                    La1:
                        androidx.compose.foundation.interaction.PressInteraction$Release r6 = new androidx.compose.foundation.interaction.PressInteraction$Release
                        r6.<init>(r2)
                    La6:
                        r9 = r6
                        androidx.compose.foundation.interaction.Interaction r9 = (androidx.compose.foundation.interaction.Interaction) r9
                        goto Lab
                    Laa:
                    Lab:
                        r2 = 1
                        r10.label = r2
                        java.lang.Object r9 = r3.emit(r9, r10)
                        if (r9 != r1) goto Lb6
                        return r1
                    Lb6:
                        r9 = r4
                    Lb7:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Interaction> flowCollector, Continuation $completion) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public Flow<Interaction> getInteractions() {
        return this.interactions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PressInteraction.Press mapPress(PressInteraction.Press press) {
        return new PressInteraction.Press(Offset.m2714minusMKHz9U(press.getPressPosition(), this.delta), null);
    }
}
