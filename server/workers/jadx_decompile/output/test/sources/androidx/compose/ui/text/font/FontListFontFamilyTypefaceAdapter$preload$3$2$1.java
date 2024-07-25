package androidx.compose.ui.text.font;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapter$preload$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ Font $font;
    final /* synthetic */ PlatformFontLoader $resourceLoader;
    int label;
    final /* synthetic */ FontListFontFamilyTypefaceAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontListFontFamilyTypefaceAdapter$preload$3$2$1(FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, Font font, PlatformFontLoader platformFontLoader, Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3$2$1> continuation) {
        super(2, continuation);
        this.this$0 = fontListFontFamilyTypefaceAdapter;
        this.$font = font;
        this.$resourceLoader = platformFontLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontListFontFamilyTypefaceAdapter$preload$3$2$1(this.this$0, this.$font, this.$resourceLoader, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((FontListFontFamilyTypefaceAdapter$preload$3$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ Font $font;
        final /* synthetic */ PlatformFontLoader $resourceLoader;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Font font, PlatformFontLoader platformFontLoader, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$font = font;
            this.$resourceLoader = platformFontLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$font, this.$resourceLoader, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
            return invoke2((Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<Object> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0041 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
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
                java.lang.String r2 = "Unable to load font "
                switch(r1) {
                    case 0: goto L1c;
                    case 1: goto L13;
                    default: goto Lb;
                }
            Lb:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L13:
                r0 = r8
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L1a
                r1 = r0
                r0 = r9
                goto L3e
            L1a:
                r1 = move-exception
                goto L5f
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)
                r1 = r8
                androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1 r3 = new androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1     // Catch: java.lang.Exception -> L5b
                androidx.compose.ui.text.font.PlatformFontLoader r4 = r1.$resourceLoader     // Catch: java.lang.Exception -> L5b
                androidx.compose.ui.text.font.Font r5 = r1.$font     // Catch: java.lang.Exception -> L5b
                r6 = 0
                r3.<init>(r4, r5, r6)     // Catch: java.lang.Exception -> L5b
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch: java.lang.Exception -> L5b
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Exception -> L5b
                r5 = 1
                r1.label = r5     // Catch: java.lang.Exception -> L5b
                r5 = 15000(0x3a98, double:7.411E-320)
                java.lang.Object r3 = kotlinx.coroutines.TimeoutKt.withTimeout(r5, r3, r4)     // Catch: java.lang.Exception -> L5b
                if (r3 != r0) goto L3c
                return r0
            L3c:
                r0 = r9
                r9 = r3
            L3e:
                if (r9 == 0) goto L42
                return r9
            L42:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.StringBuilder r2 = r3.append(r2)
                androidx.compose.ui.text.font.Font r3 = r1.$font
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r9.<init>(r2)
                throw r9
            L5b:
                r0 = move-exception
                r7 = r1
                r1 = r0
                r0 = r7
            L5f:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.StringBuilder r2 = r4.append(r2)
                androidx.compose.ui.text.font.Font r4 = r0.$font
                java.lang.StringBuilder r2 = r2.append(r4)
                java.lang.String r2 = r2.toString()
                r4 = r1
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                r3.<init>(r2, r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
            final /* synthetic */ Font $font;
            final /* synthetic */ PlatformFontLoader $resourceLoader;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00621(PlatformFontLoader platformFontLoader, Font font, Continuation<? super C00621> continuation) {
                super(2, continuation);
                this.$resourceLoader = platformFontLoader;
                this.$font = font;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00621(this.$resourceLoader, this.$font, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
                return invoke2(coroutineScope, (Continuation<Object>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
                return ((C00621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        Object awaitLoad = this.$resourceLoader.awaitLoad(this.$font, this);
                        return awaitLoad == coroutine_suspended ? coroutine_suspended : awaitLoad;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        AsyncTypefaceCache asyncTypefaceCache;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                asyncTypefaceCache = this.this$0.asyncTypefaceCache;
                this.label = 1;
                Object runCached = asyncTypefaceCache.runCached(this.$font, this.$resourceLoader, true, new AnonymousClass1(this.$font, this.$resourceLoader, null), this);
                return runCached == coroutine_suspended ? coroutine_suspended : runCached;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
