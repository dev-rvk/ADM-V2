package androidx.compose.ui.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TestModifierUpdater.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"TestModifierUpdaterLayout", "", "onAttached", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/TestModifierUpdater;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TestModifierUpdaterKt {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b1, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r9.rememberedValue(), java.lang.Integer.valueOf(r2)) != false) goto L32;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TestModifierUpdaterLayout(final kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.TestModifierUpdater, kotlin.Unit> r16, androidx.compose.runtime.Composer r17, final int r18) {
        /*
            r0 = r16
            r1 = r18
            java.lang.String r2 = "onAttached"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = -1673066036(0xffffffff9c4709cc, float:-6.585624E-22)
            r3 = r17
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(TestModifierUpdaterLayout)49@1728L23,53@1883L330:TestModifierUpdater.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r18
            r5 = r1 & 14
            r6 = 2
            if (r5 != 0) goto L29
            boolean r5 = r3.changedInstance(r0)
            if (r5 == 0) goto L27
            r5 = 4
            goto L28
        L27:
            r5 = r6
        L28:
            r4 = r4 | r5
        L29:
            r5 = r4 & 11
            if (r5 != r6) goto L3b
            boolean r5 = r3.getSkipping()
            if (r5 != 0) goto L34
            goto L3b
        L34:
            r3.skipToGroupEnd()
            r17 = r4
            goto Le3
        L3b:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L47
            r5 = -1
            java.lang.String r6 = "androidx.compose.ui.layout.TestModifierUpdaterLayout (TestModifierUpdater.kt:48)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r5, r6)
        L47:
            r2 = 0
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r2)
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 r5 = new androidx.compose.ui.layout.MeasurePolicy() { // from class: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1
                static {
                    /*
                        androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 r0 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1) androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.INSTANCE androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.<init>():void");
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final androidx.compose.ui.layout.MeasureResult mo15measure3p2s80s(androidx.compose.ui.layout.MeasureScope r9, java.util.List<? extends androidx.compose.ui.layout.Measurable> r10, long r11) {
                    /*
                        r8 = this;
                        java.lang.String r0 = "$this$MeasurePolicy"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                        java.lang.String r0 = "<anonymous parameter 0>"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                        int r2 = androidx.compose.ui.unit.Constraints.m5174getMaxWidthimpl(r11)
                        int r3 = androidx.compose.ui.unit.Constraints.m5173getMaxHeightimpl(r11)
                        androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1 r10 = new kotlin.jvm.functions.Function1<androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>() { // from class: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1
                            static {
                                /*
                                    androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1 r0 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1
                                    r0.<init>()
                                    
                                    // error: 0x0005: SPUT (r0 I:androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1) androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1.INSTANCE androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1.<clinit>():void");
                            }

                            {
                                /*
                                    r1 = this;
                                    r0 = 1
                                    r1.<init>(r0)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1.<init>():void");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ kotlin.Unit invoke(androidx.compose.ui.layout.Placeable.PlacementScope r2) {
                                /*
                                    r1 = this;
                                    r0 = r2
                                    androidx.compose.ui.layout.Placeable$PlacementScope r0 = (androidx.compose.ui.layout.Placeable.PlacementScope) r0
                                    r1.invoke2(r0)
                                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1.invoke(java.lang.Object):java.lang.Object");
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(androidx.compose.ui.layout.Placeable.PlacementScope r2) {
                                /*
                                    r1 = this;
                                    java.lang.String r0 = "$this$layout"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1.invoke2(androidx.compose.ui.layout.Placeable$PlacementScope):void");
                            }
                        }
                        r5 = r10
                        kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                        r6 = 4
                        r7 = 0
                        r4 = 0
                        r1 = r9
                        androidx.compose.ui.layout.MeasureResult r10 = androidx.compose.ui.layout.MeasureScope.layout$default(r1, r2, r3, r4, r5, r6, r7)
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.mo15measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
                }
            }
            androidx.compose.ui.layout.MeasurePolicy r5 = (androidx.compose.ui.layout.MeasurePolicy) r5
            androidx.compose.ui.node.LayoutNode$Companion r6 = androidx.compose.ui.node.LayoutNode.INSTANCE
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor$ui_release()
            r7 = 6
            r8 = 0
            r9 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r3.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r9)
            androidx.compose.runtime.Applier r9 = r3.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L6f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L6f:
            r3.startNode()
            boolean r9 = r3.getInserting()
            if (r9 == 0) goto L83
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1 r9 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1
            r9.<init>()
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r3.createNode(r9)
            goto L86
        L83:
            r3.useNode()
        L86:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m2583constructorimpl(r3)
            r10 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2590setimpl(r9, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r11.getSetCompositeKeyHash()
            r12 = 0
            r13 = r9
            r14 = 0
            boolean r15 = r13.getInserting()
            if (r15 != 0) goto Lb4
            java.lang.Object r15 = r13.rememberedValue()
            r17 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r4)
            if (r4 != 0) goto Lc4
            goto Lb6
        Lb4:
            r17 = r4
        Lb6:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r13.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r9.apply(r4, r11)
        Lc4:
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1 r4 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1
            r4.<init>()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.Updater.m2587initimpl(r9, r4)
            r3.endNode()
            r3.endReplaceableGroup()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto Le3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Le3:
            androidx.compose.runtime.ScopeUpdateScope r2 = r3.endRestartGroup()
            if (r2 != 0) goto Lea
            goto Lf4
        Lea:
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$2 r4 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$2
            r4.<init>()
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.updateScope(r4)
        Lf4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt.TestModifierUpdaterLayout(kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }
}
