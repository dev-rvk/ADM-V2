package androidx.compose.ui.graphics;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPath.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\r\u0010\u0002\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0005"}, d2 = {"Path", "Landroidx/compose/ui/graphics/Path;", "asAndroidPath", "Landroid/graphics/Path;", "asComposePath", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidPath_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Path Path() {
        return new AndroidPath(null, 1, 0 == true ? 1 : 0);
    }

    public static final Path asComposePath(android.graphics.Path $this$asComposePath) {
        Intrinsics.checkNotNullParameter($this$asComposePath, "<this>");
        return new AndroidPath($this$asComposePath);
    }

    public static final android.graphics.Path asAndroidPath(Path $this$asAndroidPath) {
        Intrinsics.checkNotNullParameter($this$asAndroidPath, "<this>");
        if ($this$asAndroidPath instanceof AndroidPath) {
            return ((AndroidPath) $this$asAndroidPath).getInternalPath();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }
}
