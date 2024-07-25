package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.tooling.PreviewLogger;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: ComposableInvoker.kt */
@Deprecated(message = "Use androidx.compose.runtime.reflect.ComposableMethodInvoker instead")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J1\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J=\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\f\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u0002H\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\b¢\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010 J9\u0010!\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f\"\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\rH\u0002J=\u0010$\u001a\u0004\u0018\u00010\u0001*\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/tooling/ComposableInvoker;", "", "()V", "BITS_PER_INT", "", "SLOTS_PER_INT", "changedParamCount", "realValueParams", "thisParams", "compatibleTypes", "", "methodTypes", "", "Ljava/lang/Class;", "actualTypes", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "defaultParamCount", "invokeComposable", "", "className", "", "methodName", "composer", "Landroidx/compose/runtime/Composer;", "args", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)V", "dup", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "findComposableMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/reflect/Method;", "getDeclaredCompatibleMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDefaultValue", "invokeComposableMethod", "instance", "(Ljava/lang/reflect/Method;Ljava/lang/Object;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)Ljava/lang/Object;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableInvoker {
    public static final int $stable = 0;
    private static final int BITS_PER_INT = 31;
    public static final ComposableInvoker INSTANCE = new ComposableInvoker();
    private static final int SLOTS_PER_INT = 10;

    private ComposableInvoker() {
    }

    private final boolean compatibleTypes(Class<?>[] methodTypes, Class<?>[] actualTypes) {
        Iterable $this$all$iv;
        if (methodTypes.length != actualTypes.length) {
            return false;
        }
        Collection destination$iv$iv = new ArrayList(methodTypes.length);
        int index$iv$iv = 0;
        int length = methodTypes.length;
        int i = 0;
        while (i < length) {
            destination$iv$iv.add(Boolean.valueOf(methodTypes[i].isAssignableFrom(actualTypes[index$iv$iv])));
            i++;
            index$iv$iv++;
        }
        Iterable $this$all$iv2 = (List) destination$iv$iv;
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator it = $this$all$iv2.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    boolean it2 = ((Boolean) element$iv).booleanValue();
                    if (!it2) {
                        $this$all$iv = null;
                        break;
                    }
                } else {
                    $this$all$iv = 1;
                    break;
                }
            }
        } else {
            $this$all$iv = 1;
        }
        return $this$all$iv != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x004f, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r12, r17 + '-', false, 2, (java.lang.Object) null) != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x006b A[LOOP:0: B:2:0x001a->B:10:0x006b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0069 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.reflect.Method getDeclaredCompatibleMethod(java.lang.Class<?> r16, java.lang.String r17, java.lang.Class<?>... r18) {
        /*
            r15 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r1, r2)
            java.lang.Class[] r2 = (java.lang.Class[]) r2
            java.lang.reflect.Method[] r3 = r16.getDeclaredMethods()
            java.lang.String r4 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r4 = 0
            int r5 = r3.length
            r6 = 0
            r7 = r6
        L1a:
            r8 = 0
            if (r7 >= r5) goto L6e
            r9 = r3[r7]
            r10 = r9
            java.lang.reflect.Method r10 = (java.lang.reflect.Method) r10
            r11 = 0
            java.lang.String r12 = r10.getName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r12)
            if (r12 != 0) goto L51
            java.lang.String r12 = r10.getName()
            java.lang.String r13 = "it.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.StringBuilder r13 = r13.append(r0)
            r14 = 45
            java.lang.StringBuilder r13 = r13.append(r14)
            java.lang.String r13 = r13.toString()
            r14 = 2
            boolean r8 = kotlin.text.StringsKt.startsWith$default(r12, r13, r6, r14, r8)
            if (r8 == 0) goto L65
        L51:
            androidx.compose.ui.tooling.ComposableInvoker r8 = androidx.compose.ui.tooling.ComposableInvoker.INSTANCE
            java.lang.Class[] r12 = r10.getParameterTypes()
            java.lang.String r13 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            boolean r8 = r8.compatibleTypes(r12, r2)
            if (r8 == 0) goto L65
            r8 = 1
            goto L66
        L65:
            r8 = r6
        L66:
            if (r8 == 0) goto L6b
            r8 = r9
            goto L6f
        L6b:
            int r7 = r7 + 1
            goto L1a
        L6e:
        L6f:
            java.lang.reflect.Method r8 = (java.lang.reflect.Method) r8
            if (r8 == 0) goto L74
            return r8
        L74:
            java.lang.NoSuchMethodException r3 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = " not found"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.getDeclaredCompatibleMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final /* synthetic */ <T> T[] dup(T t, int i) {
        IntRange until = RangesKt.until(0, i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(t);
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) arrayList.toArray(new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0111 A[Catch: ReflectiveOperationException -> 0x011a, LOOP:2: B:35:0x00d1->B:46:0x0111, LOOP_END, TryCatch #3 {ReflectiveOperationException -> 0x011a, blocks: (B:41:0x0102, B:49:0x0116, B:46:0x0111), top: B:40:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0110 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.reflect.Method findComposableMethod(java.lang.Class<?> r23, java.lang.String r24, java.lang.Object... r25) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.findComposableMethod(java.lang.Class, java.lang.String, java.lang.Object[]):java.lang.reflect.Method");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Object getDefaultValue(Class<?> cls) {
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.valueOf(0.0d);
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return 0;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return (byte) 0;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return (char) 0;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return 0L;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return false;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.valueOf(0.0f);
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return (short) 0;
                    }
                    break;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        r2 = r5;
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        if (r21 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        r7 = changedParamCount(r3, r6);
        r8 = (r3 + 1) + r7;
        r9 = r20.getParameterTypes().length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r9 == r8) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r10 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        r11 = defaultParamCount(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        if ((((r3 + 1) + r7) + r11) != r9) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (r12 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        r12 = r2 + 1;
        r13 = r12 + r7;
        r14 = new java.lang.Object[r9];
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        if (r15 >= r9) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r15 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if (r15 >= r3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        if (r16 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        if (r15 < 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0014, code lost:
    
        if (r4 >= 0) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
    
        if (r15 > kotlin.collections.ArraysKt.getLastIndex(r23)) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        r4 = r23[r15];
        r18 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c2, code lost:
    
        r14[r15] = r4;
        r15 = r15 + 1;
        r3 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
    
        r5 = androidx.compose.ui.tooling.ComposableInvoker.INSTANCE;
        r0 = r20.getParameterTypes()[r15];
        r18 = r3;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "parameterTypes[idx]");
        r4 = r5.getDefaultValue(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
    
        r18 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
    
        if (r15 != r2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
    
        r4 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        r6 = r4;
        r4 = r4 - 1;
        r7 = (java.lang.Class) r2[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a2, code lost:
    
        if (r12 > r15) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        if (r15 >= r13) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
    
        if (r0 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ab, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        if (r13 > r15) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b4, code lost:
    
        if (r15 >= r9) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b6, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7, androidx.compose.runtime.Composer.class) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b9, code lost:
    
        if (r3 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bb, code lost:
    
        r4 = 2097151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d6, code lost:
    
        throw new java.lang.IllegalStateException("Unexpected index".toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x006f, code lost:
    
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
    
        if (r4 >= 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e5, code lost:
    
        return r20.invoke(r21, java.util.Arrays.copyOf(r14, r14.length));
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f3, code lost:
    
        throw new java.lang.IllegalStateException("Check failed.".toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x005b, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004c, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0044, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0030, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        r5 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object invokeComposableMethod(java.lang.reflect.Method r20, java.lang.Object r21, androidx.compose.runtime.Composer r22, java.lang.Object... r23) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.invokeComposableMethod(java.lang.reflect.Method, java.lang.Object, androidx.compose.runtime.Composer, java.lang.Object[]):java.lang.Object");
    }

    private final int changedParamCount(int realValueParams, int thisParams) {
        if (realValueParams == 0) {
            return 1;
        }
        int totalParams = realValueParams + thisParams;
        return (int) Math.ceil(totalParams / 10.0d);
    }

    private final int defaultParamCount(int realValueParams) {
        return (int) Math.ceil(realValueParams / 31.0d);
    }

    public final void invokeComposable(String className, String methodName, Composer composer, Object... args) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            Class composableClass = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(composableClass, "composableClass");
            Method method = findComposableMethod(composableClass, methodName, Arrays.copyOf(args, args.length));
            method.setAccessible(true);
            if (Modifier.isStatic(method.getModifiers())) {
                invokeComposableMethod(method, null, composer, Arrays.copyOf(args, args.length));
            } else {
                Object instance = composableClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                invokeComposableMethod(method, instance, composer, Arrays.copyOf(args, args.length));
            }
        } catch (ReflectiveOperationException e) {
            PreviewLogger.Companion.logWarning$ui_tooling_release$default(PreviewLogger.INSTANCE, "Failed to invoke Composable Method '" + className + '.' + methodName + '\'', null, 2, null);
            throw e;
        }
    }
}
