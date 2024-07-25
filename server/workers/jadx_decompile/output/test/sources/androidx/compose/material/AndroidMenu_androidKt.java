package androidx.compose.material;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AndroidMenu.android.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aq\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001aa\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:27:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f1  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @kotlin.ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m962DropdownMenuILWXrKs(final boolean r28, final kotlin.jvm.functions.Function0 r29, androidx.compose.ui.Modifier r30, long r31, androidx.compose.ui.window.PopupProperties r33, final kotlin.jvm.functions.Function3 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.m962DropdownMenuILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0131  */
    /* renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m961DropdownMenu4kj_NE(final boolean r28, final kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, long r31, androidx.compose.foundation.ScrollState r33, androidx.compose.ui.window.PopupProperties r34, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.m961DropdownMenu4kj_NE(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.foundation.ScrollState, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DropdownMenuItem(final kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, androidx.compose.foundation.layout.PaddingValues r22, androidx.compose.foundation.interaction.MutableInteractionSource r23, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.DropdownMenuItem(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
