package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0017JK\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u001e\u0010\u0019\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\u0086\bø\u0001\u0003R\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "", "()V", "PermanentFailure", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "Ljava/lang/Object;", "cacheLock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "permanentCache", "Landroidx/compose/ui/text/caches/SimpleArrayMap;", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "get", "font", "Landroidx/compose/ui/text/font/Font;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "get-1ASDuI8", "put", "", "result", "forever", "", "runCached", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/PlatformFontLoader;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCachedBlocking", "Lkotlin/Function0;", "AsyncTypefaceResult", "Key", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AsyncTypefaceCache {
    private final Object PermanentFailure = AsyncTypefaceResult.m4779constructorimpl(null);
    private final LruCache<Key, AsyncTypefaceResult> resultCache = new LruCache<>(16);
    private final SimpleArrayMap<Key, AsyncTypefaceResult> permanentCache = new SimpleArrayMap<>(0, 1, null);
    private final SynchronizedObject cacheLock = Synchronization_jvmKt.createSynchronizedObject();

    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "", "result", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isPermanentFailure", "", "isPermanentFailure-impl", "(Ljava/lang/Object;)Z", "getResult", "()Ljava/lang/Object;", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @JvmInline
    /* loaded from: classes.dex */
    public static final class AsyncTypefaceResult {
        private final Object result;

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ AsyncTypefaceResult m4778boximpl(Object obj) {
            return new AsyncTypefaceResult(obj);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static Object m4779constructorimpl(Object obj) {
            return obj;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m4780equalsimpl(Object obj, Object obj2) {
            return (obj2 instanceof AsyncTypefaceResult) && Intrinsics.areEqual(obj, ((AsyncTypefaceResult) obj2).m4785unboximpl());
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m4781equalsimpl0(Object obj, Object obj2) {
            return Intrinsics.areEqual(obj, obj2);
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m4782hashCodeimpl(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m4784toStringimpl(Object obj) {
            return "AsyncTypefaceResult(result=" + obj + ')';
        }

        public boolean equals(Object obj) {
            return m4780equalsimpl(this.result, obj);
        }

        public int hashCode() {
            return m4782hashCodeimpl(this.result);
        }

        public String toString() {
            return m4784toStringimpl(this.result);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ Object m4785unboximpl() {
            return this.result;
        }

        private /* synthetic */ AsyncTypefaceResult(Object result) {
            this.result = result;
        }

        public final Object getResult() {
            return this.result;
        }

        /* renamed from: isPermanentFailure-impl, reason: not valid java name */
        public static final boolean m4783isPermanentFailureimpl(Object arg0) {
            return arg0 == null;
        }
    }

    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "", "font", "Landroidx/compose/ui/text/font/Font;", "loaderKey", "(Landroidx/compose/ui/text/font/Font;Ljava/lang/Object;)V", "getFont", "()Landroidx/compose/ui/text/font/Font;", "getLoaderKey", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class Key {
        private final Font font;
        private final Object loaderKey;

        public static /* synthetic */ Key copy$default(Key key, Font font, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                font = key.font;
            }
            if ((i & 2) != 0) {
                obj = key.loaderKey;
            }
            return key.copy(font, obj);
        }

        /* renamed from: component1, reason: from getter */
        public final Font getFont() {
            return this.font;
        }

        /* renamed from: component2, reason: from getter */
        public final Object getLoaderKey() {
            return this.loaderKey;
        }

        public final Key copy(Font font, Object loaderKey) {
            Intrinsics.checkNotNullParameter(font, "font");
            return new Key(font, loaderKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            return Intrinsics.areEqual(this.font, key.font) && Intrinsics.areEqual(this.loaderKey, key.loaderKey);
        }

        public int hashCode() {
            return (this.font.hashCode() * 31) + (this.loaderKey == null ? 0 : this.loaderKey.hashCode());
        }

        public String toString() {
            return "Key(font=" + this.font + ", loaderKey=" + this.loaderKey + ')';
        }

        public Key(Font font, Object loaderKey) {
            Intrinsics.checkNotNullParameter(font, "font");
            this.font = font;
            this.loaderKey = loaderKey;
        }

        public final Font getFont() {
            return this.font;
        }

        public final Object getLoaderKey() {
            return this.loaderKey;
        }
    }

    public static /* synthetic */ void put$default(AsyncTypefaceCache asyncTypefaceCache, Font font, PlatformFontLoader platformFontLoader, Object obj, boolean z, int i, Object obj2) {
        if ((i & 8) != 0) {
            z = false;
        }
        asyncTypefaceCache.put(font, platformFontLoader, obj, z);
    }

    public final void put(Font font, PlatformFontLoader platformFontLoader, Object result, boolean forever) {
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Key key = new Key(font, platformFontLoader.getCacheKey());
        SynchronizedObject lock$iv = this.cacheLock;
        synchronized (lock$iv) {
            try {
                if (result == null) {
                    this.permanentCache.put(key, AsyncTypefaceResult.m4778boximpl(this.PermanentFailure));
                } else if (forever) {
                    this.permanentCache.put(key, AsyncTypefaceResult.m4778boximpl(AsyncTypefaceResult.m4779constructorimpl(result)));
                } else {
                    this.resultCache.put(key, AsyncTypefaceResult.m4778boximpl(AsyncTypefaceResult.m4779constructorimpl(result)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: get-1ASDuI8, reason: not valid java name */
    public final AsyncTypefaceResult m4777get1ASDuI8(Font font, PlatformFontLoader platformFontLoader) {
        AsyncTypefaceResult asyncTypefaceResult;
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Key key = new Key(font, platformFontLoader.getCacheKey());
        SynchronizedObject lock$iv = this.cacheLock;
        synchronized (lock$iv) {
            asyncTypefaceResult = this.resultCache.get(key);
            if (asyncTypefaceResult == null) {
                asyncTypefaceResult = this.permanentCache.get(key);
            }
        }
        return asyncTypefaceResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runCached(androidx.compose.ui.text.font.Font r8, androidx.compose.ui.text.font.PlatformFontLoader r9, boolean r10, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> r11, kotlin.coroutines.Continuation<java.lang.Object> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = (androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            r0.<init>(r7, r12)
        L19:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            switch(r2) {
                case 0: goto L3e;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2d:
            boolean r8 = r12.Z$0
            java.lang.Object r9 = r12.L$1
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r9 = (androidx.compose.ui.text.font.AsyncTypefaceCache.Key) r9
            java.lang.Object r10 = r12.L$0
            androidx.compose.ui.text.font.AsyncTypefaceCache r10 = (androidx.compose.ui.text.font.AsyncTypefaceCache) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r10
            r10 = r8
            r8 = r0
            goto L7f
        L3e:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r3 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key
            java.lang.Object r4 = r9.getCacheKey()
            r3.<init>(r8, r4)
            r9 = r3
            androidx.compose.ui.text.platform.SynchronizedObject r8 = r2.cacheLock
            r3 = 0
            monitor-enter(r8)
            r4 = 0
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r5 = r2.resultCache     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r5 = r5.get(r9)     // Catch: java.lang.Throwable -> Lbd
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r5 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r5     // Catch: java.lang.Throwable -> Lbd
            if (r5 != 0) goto L63
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r5 = r2.permanentCache     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r5 = r5.get(r9)     // Catch: java.lang.Throwable -> Lbd
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r5 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r5     // Catch: java.lang.Throwable -> Lbd
        L63:
            if (r5 == 0) goto L6b
            java.lang.Object r9 = r5.m4785unboximpl()     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r8)
            return r9
        L6b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r8)
            r12.L$0 = r2
            r12.L$1 = r9
            r12.Z$0 = r10
            r8 = 1
            r12.label = r8
            java.lang.Object r8 = r11.invoke(r12)
            if (r8 != r1) goto L7f
            return r1
        L7f:
            r11 = r8
            r1 = 0
            androidx.compose.ui.text.platform.SynchronizedObject r3 = r2.cacheLock
            r4 = 0
            monitor-enter(r3)
            r5 = 0
            if (r11 != 0) goto L97
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r10 = r2.permanentCache     // Catch: java.lang.Throwable -> L95
            java.lang.Object r11 = r2.PermanentFailure     // Catch: java.lang.Throwable -> L95
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r11 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m4778boximpl(r11)     // Catch: java.lang.Throwable -> L95
            r10.put(r9, r11)     // Catch: java.lang.Throwable -> L95
            goto Lb5
        L95:
            r8 = move-exception
            goto Lbb
        L97:
            if (r10 == 0) goto La8
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r10 = r2.permanentCache     // Catch: java.lang.Throwable -> L95
            java.lang.Object r6 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m4779constructorimpl(r11)     // Catch: java.lang.Throwable -> L95
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r6 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m4778boximpl(r6)     // Catch: java.lang.Throwable -> L95
            r10.put(r9, r6)     // Catch: java.lang.Throwable -> L95
            goto Lb5
        La8:
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r10 = r2.resultCache     // Catch: java.lang.Throwable -> L95
            java.lang.Object r6 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m4779constructorimpl(r11)     // Catch: java.lang.Throwable -> L95
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r6 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m4778boximpl(r6)     // Catch: java.lang.Throwable -> L95
            r10.put(r9, r6)     // Catch: java.lang.Throwable -> L95
        Lb5:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L95
            monitor-exit(r3)
            return r8
        Lbb:
            monitor-exit(r3)
            throw r8
        Lbd:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncTypefaceCache.runCached(androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.PlatformFontLoader, boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object runCachedBlocking(Font font, PlatformFontLoader platformFontLoader, Function0<? extends Object> block) {
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Intrinsics.checkNotNullParameter(block, "block");
        SynchronizedObject lock$iv = this.cacheLock;
        synchronized (lock$iv) {
            try {
                Key key = new Key(font, platformFontLoader.getCacheKey());
                AsyncTypefaceResult priorResult = (AsyncTypefaceResult) this.resultCache.get(key);
                if (priorResult == null) {
                    priorResult = (AsyncTypefaceResult) this.permanentCache.get(key);
                }
                if (priorResult != null) {
                    Object m4785unboximpl = priorResult.m4785unboximpl();
                    InlineMarker.finallyStart(2);
                    InlineMarker.finallyEnd(2);
                    return m4785unboximpl;
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                Object it = block.invoke();
                put$default(this, font, platformFontLoader, it, false, 8, null);
                return it;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }
}
