package com.fakepay;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class FakePayScreen extends Screen {
    private final String player, amount;

    public FakePayScreen(String player, String amount) {
        super(Text.literal("Confirm Payment"));
        this.player = player;
        this.amount = amount;
    }

    @Override
    protected void init() {
        int cx = width / 2, cy = height / 2;
        addDrawableChild(ButtonWidget.builder(Text.literal("§aConfirm"), b -> {
            close();
            // TODO: replace with the exact DonutSMP message
            client.player.sendMessage(Text.literal("§aYou paid §f" + player + " §a$" + amount), false);
        }).dimensions(cx - 105, cy + 20, 100, 22).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("§cCancel"), b -> close())
            .dimensions(cx + 5, cy + 20, 100, 22).build());
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        renderBackground(ctx, mouseX, mouseY, delta);
        int cx = width / 2, cy = height / 2;
        ctx.fill(cx - 120, cy - 60, cx + 120, cy + 55, 0xCC101018);
        ctx.fill(cx - 120, cy - 60, cx + 120, cy - 57, 0xFFFFAA00);
        ctx.drawCenteredTextWithShadow(textRenderer, "§6§lConfirm Payment", cx, cy - 45, 0xFFFFFF);
        ctx.drawCenteredTextWithShadow(textRenderer, "§7To: §f" + player, cx, cy - 20, 0xFFFFFF);
        ctx.drawCenteredTextWithShadow(textRenderer, "§7Amount: §a$" + amount, cx, cy - 5, 0xFFFFFF);
        super.render(ctx, mouseX, mouseY, delta);
    }
}
