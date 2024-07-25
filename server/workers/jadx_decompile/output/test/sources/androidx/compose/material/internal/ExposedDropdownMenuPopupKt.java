package androidx.compose.material.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: ExposedDropdownMenuPopup.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a:\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0083\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012²\u0006\u0015\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fX\u008a\u0084\u0002"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuPopupKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0<String>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);

    /* JADX WARN: Removed duplicated region for block: B:42:0x02b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0<kotlin.Unit> r28, final androidx.compose.ui.window.PopupPositionProvider r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0094, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r11.rememberedValue(), java.lang.Integer.valueOf(r5)) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void SimpleStack(androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22) {
        /*
            r0 = r21
            r1 = 0
            r2 = 1769324208(0x6975beb0, float:1.8567958E25)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(SimpleStack)P(1)178@6799L979:ExposedDropdownMenuPopup.kt#mnwmf7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$SimpleStack$1 r2 = androidx.compose.material.internal.ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r2 = (androidx.compose.ui.layout.MeasurePolicy) r2
            int r3 = r22 >> 3
            r3 = r3 & 14
            int r4 = r22 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r5 = 0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r0, r5)
            androidx.compose.runtime.CompositionLocalMap r6 = r21.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r19)
            int r9 = r3 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r10 = 0
            androidx.compose.runtime.Applier r11 = r21.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L4d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L4d:
            r21.startReusableNode()
            boolean r11 = r21.getInserting()
            if (r11 == 0) goto L5a
            r0.createNode(r7)
            goto L5d
        L5a:
            r21.useNode()
        L5d:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2583constructorimpl(r21)
            r12 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2590setimpl(r11, r2, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2590setimpl(r11, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r14 = 0
            r15 = r11
            r16 = 0
            boolean r17 = r15.getInserting()
            if (r17 != 0) goto L97
            r17 = r1
            java.lang.Object r1 = r15.rememberedValue()
            r18 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 != 0) goto La9
            goto L9b
        L97:
            r17 = r1
            r18 = r2
        L9b:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r15.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r11.apply(r1, r13)
        La9:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2575constructorimpl(r21)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2574boximpl(r1)
            int r2 = r9 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8.invoke(r1, r0, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            int r1 = r9 >> 9
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r20
            r2.invoke(r0, r1)
            r21.endReplaceableGroup()
            r21.endNode()
            r21.endReplaceableGroup()
            r21.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.ExposedDropdownMenuPopupKt.SimpleStack(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}
