package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusRequester.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fH\u0083\bJ\r\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester;", "", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "captureFocus", "", "findFocusTarget", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focus", "focus$ui_release", "freeFocus", "requestFocus", "", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusRequester {
    public static final int $stable = 0;
    private final MutableVector<FocusRequesterModifierNode> focusRequesterNodes = new MutableVector<>(new FocusRequesterModifierNode[16], 0);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FocusRequester Default = new FocusRequester();
    private static final FocusRequester Cancel = new FocusRequester();

    public final MutableVector<FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        focus$ui_release();
    }

    public final boolean focus$ui_release() {
        int i;
        Modifier.Node child$iv$iv$iv;
        boolean success$iv;
        boolean m2671findChildCorrespondingToFocusEnterOMvw8;
        Modifier.Node branch$iv$iv$iv;
        DelegatingNode this_$iv$iv$iv$iv;
        int $i$f$forEachImmediateDelegate$ui_release;
        Modifier.Node branch$iv$iv$iv2;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        FocusRequester this_$iv = this;
        int $i$f$findFocusTarget = 0;
        int i2 = 0;
        if (!(this_$iv != INSTANCE.getDefault())) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        }
        if (!(this_$iv != INSTANCE.getCancel())) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        }
        if (!this_$iv.focusRequesterNodes.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        boolean success$iv2 = false;
        MutableVector this_$iv$iv = this_$iv.focusRequesterNodes;
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            while (true) {
                DelegatableNode node$iv = (FocusRequesterModifierNode) content$iv$iv[i$iv$iv];
                DelegatableNode $this$visitChildren_u2d6rFNWt0$iv$iv = node$iv;
                int m4400constructorimpl = NodeKind.m4400constructorimpl(1024);
                if (!$this$visitChildren_u2d6rFNWt0$iv$iv.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                FocusRequester this_$iv2 = this_$iv;
                int $i$f$findFocusTarget2 = $i$f$findFocusTarget;
                MutableVector branches$iv$iv$iv = new MutableVector(new Modifier.Node[16], i2);
                Modifier.Node child$iv$iv$iv2 = $this$visitChildren_u2d6rFNWt0$iv$iv.getNode().getChild();
                if (child$iv$iv$iv2 == null) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(branches$iv$iv$iv, $this$visitChildren_u2d6rFNWt0$iv$iv.getNode());
                } else {
                    branches$iv$iv$iv.add(child$iv$iv$iv2);
                }
                while (true) {
                    if (!branches$iv$iv$iv.isNotEmpty()) {
                        i = i2;
                        break;
                    }
                    MutableVector this_$iv$iv$iv$iv2 = branches$iv$iv$iv;
                    Modifier.Node branch$iv$iv$iv3 = (Modifier.Node) branches$iv$iv$iv.removeAt(this_$iv$iv$iv$iv2.getSize() - 1);
                    if ((branch$iv$iv$iv3.getAggregateChildKindSet() & m4400constructorimpl) != 0) {
                        Modifier.Node node$iv$iv$iv = branch$iv$iv$iv3;
                        while (true) {
                            if (node$iv$iv$iv == null) {
                                child$iv$iv$iv2 = child$iv$iv$iv2;
                                break;
                            }
                            if ((node$iv$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                                Modifier.Node it$iv$iv = node$iv$iv$iv;
                                MutableVector mutableVector2 = null;
                                Modifier.Node node = it$iv$iv;
                                while (node != null) {
                                    MutableVector branches$iv$iv$iv2 = branches$iv$iv$iv;
                                    if (node instanceof FocusTargetNode) {
                                        FocusTargetNode it$iv = (FocusTargetNode) node;
                                        FocusProperties focusProperties = it$iv.fetchFocusProperties$ui_release();
                                        if (focusProperties.getCanFocus()) {
                                            child$iv$iv$iv = child$iv$iv$iv2;
                                            m2671findChildCorrespondingToFocusEnterOMvw8 = FocusTransactionsKt.requestFocus(it$iv);
                                            success$iv = success$iv2;
                                        } else {
                                            child$iv$iv$iv = child$iv$iv$iv2;
                                            success$iv = success$iv2;
                                            m2671findChildCorrespondingToFocusEnterOMvw8 = TwoDimensionalFocusSearchKt.m2671findChildCorrespondingToFocusEnterOMvw8(it$iv, FocusDirection.INSTANCE.m2638getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequester$focus$1$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Boolean invoke(FocusTargetNode it) {
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    return Boolean.valueOf(FocusTransactionsKt.requestFocus(it));
                                                }
                                            });
                                        }
                                        if (m2671findChildCorrespondingToFocusEnterOMvw8) {
                                            success$iv2 = true;
                                            i = 0;
                                            break;
                                        }
                                        branch$iv$iv$iv = branch$iv$iv$iv3;
                                    } else {
                                        child$iv$iv$iv = child$iv$iv$iv2;
                                        success$iv = success$iv2;
                                        Modifier.Node this_$iv$iv$iv$iv3 = node;
                                        if (((this_$iv$iv$iv$iv3.getKindSet() & m4400constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                            int count$iv$iv$iv2 = 0;
                                            DelegatingNode this_$iv$iv$iv$iv4 = (DelegatingNode) node;
                                            int $i$f$forEachImmediateDelegate$ui_release2 = 0;
                                            Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv4.getDelegate();
                                            while (node$iv$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                                if ((next$iv$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                                                    count$iv$iv$iv2++;
                                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv4;
                                                    if (count$iv$iv$iv2 == 1) {
                                                        node = next$iv$iv$iv;
                                                        $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                        branch$iv$iv$iv2 = branch$iv$iv$iv3;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            count$iv$iv$iv = count$iv$iv$iv2;
                                                            $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                            branch$iv$iv$iv2 = branch$iv$iv$iv3;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv$iv = count$iv$iv$iv2;
                                                            $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                            branch$iv$iv$iv2 = branch$iv$iv$iv3;
                                                            mutableVector = mutableVector2;
                                                        }
                                                        MutableVector mutableVector3 = mutableVector;
                                                        Modifier.Node theNode$iv$iv$iv = node;
                                                        if (theNode$iv$iv$iv != null) {
                                                            if (mutableVector3 != null) {
                                                                mutableVector3.add(theNode$iv$iv$iv);
                                                            }
                                                            node = null;
                                                        }
                                                        if (mutableVector3 != null) {
                                                            mutableVector3.add(next$iv$iv$iv);
                                                        }
                                                        mutableVector2 = mutableVector3;
                                                        count$iv$iv$iv2 = count$iv$iv$iv;
                                                    }
                                                } else {
                                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv4;
                                                    $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                    branch$iv$iv$iv2 = branch$iv$iv$iv3;
                                                }
                                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                                this_$iv$iv$iv$iv4 = this_$iv$iv$iv$iv;
                                                $i$f$forEachImmediateDelegate$ui_release2 = $i$f$forEachImmediateDelegate$ui_release;
                                                branch$iv$iv$iv3 = branch$iv$iv$iv2;
                                            }
                                            branch$iv$iv$iv = branch$iv$iv$iv3;
                                            if (count$iv$iv$iv2 == 1) {
                                                branches$iv$iv$iv = branches$iv$iv$iv2;
                                                success$iv2 = success$iv;
                                                child$iv$iv$iv2 = child$iv$iv$iv;
                                                branch$iv$iv$iv3 = branch$iv$iv$iv;
                                            }
                                        } else {
                                            branch$iv$iv$iv = branch$iv$iv$iv3;
                                        }
                                    }
                                    node = DelegatableNodeKt.access$pop(mutableVector2);
                                    branches$iv$iv$iv = branches$iv$iv$iv2;
                                    success$iv2 = success$iv;
                                    child$iv$iv$iv2 = child$iv$iv$iv;
                                    branch$iv$iv$iv3 = branch$iv$iv$iv;
                                }
                                i2 = 0;
                                child$iv$iv$iv2 = child$iv$iv$iv2;
                            } else {
                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                child$iv$iv$iv2 = child$iv$iv$iv2;
                                branch$iv$iv$iv3 = branch$iv$iv$iv3;
                            }
                        }
                    } else {
                        DelegatableNodeKt.access$addLayoutNodeChildren(branches$iv$iv$iv, branch$iv$iv$iv3);
                    }
                }
                i$iv$iv++;
                if (i$iv$iv >= size$iv$iv) {
                    break;
                }
                i2 = i;
                this_$iv = this_$iv2;
                $i$f$findFocusTarget = $i$f$findFocusTarget2;
            }
        }
        return success$iv2;
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0020 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean captureFocus() {
        /*
            r8 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> r0 = r8.focusRequesterNodes
            boolean r0 = r0.isNotEmpty()
            if (r0 == 0) goto L2d
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> r0 = r8.focusRequesterNodes
            r1 = 0
            int r2 = r0.getSize()
            if (r2 <= 0) goto L2a
            r3 = 0
            java.lang.Object[] r4 = r0.getContent()
        L17:
            r5 = r4[r3]
            androidx.compose.ui.focus.FocusRequesterModifierNode r5 = (androidx.compose.ui.focus.FocusRequesterModifierNode) r5
            r6 = 0
            boolean r7 = androidx.compose.ui.focus.FocusRequesterModifierNodeKt.captureFocus(r5)
            if (r7 == 0) goto L24
            r7 = 1
            return r7
        L24:
            int r3 = r3 + 1
            if (r3 < r2) goto L17
        L2a:
        L2b:
            r0 = 0
            return r0
        L2d:
            r0 = 0
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequester.captureFocus():boolean");
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0020 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean freeFocus() {
        /*
            r8 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> r0 = r8.focusRequesterNodes
            boolean r0 = r0.isNotEmpty()
            if (r0 == 0) goto L2d
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> r0 = r8.focusRequesterNodes
            r1 = 0
            int r2 = r0.getSize()
            if (r2 <= 0) goto L2a
            r3 = 0
            java.lang.Object[] r4 = r0.getContent()
        L17:
            r5 = r4[r3]
            androidx.compose.ui.focus.FocusRequesterModifierNode r5 = (androidx.compose.ui.focus.FocusRequesterModifierNode) r5
            r6 = 0
            boolean r7 = androidx.compose.ui.focus.FocusRequesterModifierNodeKt.freeFocus(r5)
            if (r7 == 0) goto L24
            r7 = 1
            return r7
        L24:
            int r3 = r3 + 1
            if (r3 < r2) goto L17
        L2a:
        L2b:
            r0 = 0
            return r0
        L2d:
            r0 = 0
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequester.freeFocus():boolean");
    }

    /* compiled from: FocusRequester.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "()V", "Cancel", "Landroidx/compose/ui/focus/FocusRequester;", "getCancel$annotations", "getCancel", "()Landroidx/compose/ui/focus/FocusRequester;", "Default", "getDefault", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCancel$annotations() {
        }

        private Companion() {
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }

        /* compiled from: FocusRequester.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0006\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0007\u001a\u00020\u0004H\u0086\u0002J\t\u0010\b\u001a\u00020\u0004H\u0086\u0002J\t\u0010\t\u001a\u00020\u0004H\u0086\u0002J\t\u0010\n\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u000b\u001a\u00020\u0004H\u0086\u0002J\t\u0010\f\u001a\u00020\u0004H\u0086\u0002J\t\u0010\r\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u000f\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0010\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0011\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0012\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0013\u001a\u00020\u0004H\u0086\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "", "()V", "component1", "Landroidx/compose/ui/focus/FocusRequester;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class FocusRequesterFactory {
            public static final int $stable = 0;
            public static final FocusRequesterFactory INSTANCE = new FocusRequesterFactory();

            private FocusRequesterFactory() {
            }

            public final FocusRequester component1() {
                return new FocusRequester();
            }

            public final FocusRequester component2() {
                return new FocusRequester();
            }

            public final FocusRequester component3() {
                return new FocusRequester();
            }

            public final FocusRequester component4() {
                return new FocusRequester();
            }

            public final FocusRequester component5() {
                return new FocusRequester();
            }

            public final FocusRequester component6() {
                return new FocusRequester();
            }

            public final FocusRequester component7() {
                return new FocusRequester();
            }

            public final FocusRequester component8() {
                return new FocusRequester();
            }

            public final FocusRequester component9() {
                return new FocusRequester();
            }

            public final FocusRequester component10() {
                return new FocusRequester();
            }

            public final FocusRequester component11() {
                return new FocusRequester();
            }

            public final FocusRequester component12() {
                return new FocusRequester();
            }

            public final FocusRequester component13() {
                return new FocusRequester();
            }

            public final FocusRequester component14() {
                return new FocusRequester();
            }

            public final FocusRequester component15() {
                return new FocusRequester();
            }

            public final FocusRequester component16() {
                return new FocusRequester();
            }
        }

        public final FocusRequesterFactory createRefs() {
            return FocusRequesterFactory.INSTANCE;
        }
    }

    private final boolean findFocusTarget(Function1<? super FocusTargetNode, Boolean> onFound) {
        int i;
        Modifier.Node child$iv$iv;
        boolean success;
        Modifier.Node branch$iv$iv;
        boolean success2;
        Modifier.Node branch$iv$iv2;
        int count$iv$iv;
        MutableVector mutableVector;
        int $i$f$findFocusTarget = 0;
        int i2 = 0;
        if (!(this != INSTANCE.getDefault())) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        }
        if (!(this != INSTANCE.getCancel())) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        }
        if (!this.focusRequesterNodes.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        boolean success3 = false;
        MutableVector this_$iv = this.focusRequesterNodes;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            while (true) {
                DelegatableNode node = (FocusRequesterModifierNode) content$iv[i$iv];
                DelegatableNode $this$visitChildren_u2d6rFNWt0$iv = node;
                int m4400constructorimpl = NodeKind.m4400constructorimpl(1024);
                if (!$this$visitChildren_u2d6rFNWt0$iv.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                int $i$f$findFocusTarget2 = $i$f$findFocusTarget;
                MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], i2);
                Modifier.Node child$iv$iv2 = $this$visitChildren_u2d6rFNWt0$iv.getNode().getChild();
                if (child$iv$iv2 == null) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(branches$iv$iv, $this$visitChildren_u2d6rFNWt0$iv.getNode());
                } else {
                    branches$iv$iv.add(child$iv$iv2);
                }
                while (true) {
                    if (!branches$iv$iv.isNotEmpty()) {
                        i = i2;
                        break;
                    }
                    MutableVector this_$iv$iv$iv = branches$iv$iv;
                    Modifier.Node branch$iv$iv3 = (Modifier.Node) branches$iv$iv.removeAt(this_$iv$iv$iv.getSize() - 1);
                    if ((branch$iv$iv3.getAggregateChildKindSet() & m4400constructorimpl) == 0) {
                        DelegatableNodeKt.access$addLayoutNodeChildren(branches$iv$iv, branch$iv$iv3);
                    } else {
                        Modifier.Node node$iv$iv = branch$iv$iv3;
                        while (true) {
                            if (node$iv$iv == null) {
                                child$iv$iv2 = child$iv$iv2;
                                break;
                            }
                            if ((node$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                                Modifier.Node it$iv = node$iv$iv;
                                MutableVector mutableVector2 = null;
                                Modifier.Node node2 = it$iv;
                                while (node2 != null) {
                                    MutableVector branches$iv$iv2 = branches$iv$iv;
                                    if (node2 instanceof FocusTargetNode) {
                                        FocusTargetNode it = (FocusTargetNode) node2;
                                        child$iv$iv = child$iv$iv2;
                                        if (onFound.invoke(it).booleanValue()) {
                                            success3 = true;
                                            i = 0;
                                            break;
                                        }
                                        success = success3;
                                        branch$iv$iv = branch$iv$iv3;
                                    } else {
                                        child$iv$iv = child$iv$iv2;
                                        Modifier.Node this_$iv$iv$iv2 = node2;
                                        if (!((this_$iv$iv$iv2.getKindSet() & m4400constructorimpl) != 0) || !(node2 instanceof DelegatingNode)) {
                                            success = success3;
                                            branch$iv$iv = branch$iv$iv3;
                                        } else {
                                            int count$iv$iv2 = 0;
                                            DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) node2;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv3.getDelegate();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if (!((next$iv$iv.getKindSet() & m4400constructorimpl) != 0)) {
                                                    success2 = success3;
                                                    branch$iv$iv2 = branch$iv$iv3;
                                                } else {
                                                    count$iv$iv2++;
                                                    if (count$iv$iv2 == 1) {
                                                        node2 = next$iv$iv;
                                                        success2 = success3;
                                                        branch$iv$iv2 = branch$iv$iv3;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            count$iv$iv = count$iv$iv2;
                                                            success2 = success3;
                                                            branch$iv$iv2 = branch$iv$iv3;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv = count$iv$iv2;
                                                            success2 = success3;
                                                            branch$iv$iv2 = branch$iv$iv3;
                                                            mutableVector = mutableVector2;
                                                        }
                                                        MutableVector mutableVector3 = mutableVector;
                                                        Modifier.Node theNode$iv$iv = node2;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector3 != null) {
                                                                mutableVector3.add(theNode$iv$iv);
                                                            }
                                                            node2 = null;
                                                        }
                                                        if (mutableVector3 != null) {
                                                            mutableVector3.add(next$iv$iv);
                                                        }
                                                        mutableVector2 = mutableVector3;
                                                        count$iv$iv2 = count$iv$iv;
                                                    }
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                                success3 = success2;
                                                branch$iv$iv3 = branch$iv$iv2;
                                            }
                                            success = success3;
                                            branch$iv$iv = branch$iv$iv3;
                                            if (count$iv$iv2 == 1) {
                                                branches$iv$iv = branches$iv$iv2;
                                                child$iv$iv2 = child$iv$iv;
                                                success3 = success;
                                                branch$iv$iv3 = branch$iv$iv;
                                            }
                                        }
                                    }
                                    node2 = DelegatableNodeKt.access$pop(mutableVector2);
                                    branches$iv$iv = branches$iv$iv2;
                                    child$iv$iv2 = child$iv$iv;
                                    success3 = success;
                                    branch$iv$iv3 = branch$iv$iv;
                                }
                                i2 = 0;
                                child$iv$iv2 = child$iv$iv2;
                            } else {
                                node$iv$iv = node$iv$iv.getChild();
                                child$iv$iv2 = child$iv$iv2;
                                branch$iv$iv3 = branch$iv$iv3;
                            }
                        }
                    }
                }
                i$iv++;
                if (i$iv >= size$iv) {
                    break;
                }
                i2 = i;
                $i$f$findFocusTarget = $i$f$findFocusTarget2;
            }
        }
        return success3;
    }
}
