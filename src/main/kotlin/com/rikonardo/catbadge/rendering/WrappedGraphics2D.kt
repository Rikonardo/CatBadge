package com.rikonardo.catbadge.rendering

import java.awt.*
import java.awt.font.FontRenderContext
import java.awt.font.GlyphVector
import java.awt.geom.AffineTransform
import java.awt.image.BufferedImage
import java.awt.image.BufferedImageOp
import java.awt.image.ImageObserver
import java.awt.image.RenderedImage
import java.awt.image.renderable.RenderableImage
import java.text.AttributedCharacterIterator

class WrappedGraphics2D(width: Int, height: Int, type: Int): Graphics2D() {
    val image = BufferedImage(width, height, type)
    private val gr = image.createGraphics()

    override fun create(): Graphics {
        return gr.create()
    }

    override fun translate(x: Int, y: Int) {
        gr.translate(x, y)
    }

    override fun translate(tx: Double, ty: Double) {
        gr.translate(tx, ty)
    }

    override fun getColor(): Color {
        return gr.color
    }

    override fun setColor(c: Color?) {
        gr.color = c
    }

    override fun setPaintMode() {
        gr.setPaintMode()
    }

    override fun setXORMode(c1: Color?) {
        gr.setXORMode(c1)
    }

    override fun getFont(): Font {
        return gr.font
    }

    override fun setFont(font: Font?) {
        gr.font = font
    }

    override fun getFontMetrics(f: Font?): FontMetrics {
        return gr.fontMetrics
    }

    override fun getClipBounds(): Rectangle {
        return gr.clipBounds
    }

    override fun clipRect(x: Int, y: Int, width: Int, height: Int) {
        gr.clipRect(x, y, width, height)
    }

    override fun setClip(x: Int, y: Int, width: Int, height: Int) {
        gr.setClip(x, y, width, height)
    }

    override fun setClip(clip: Shape?) {
        gr.clip = clip
    }

    override fun getClip(): Shape {
        return gr.clip
    }

    override fun copyArea(x: Int, y: Int, width: Int, height: Int, dx: Int, dy: Int) {
        gr.copyArea(x, y, width, height, dx, dy)
    }

    override fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int) {
        gr.drawLine(x1, y1, x2, y2)
    }

    override fun fillRect(x: Int, y: Int, width: Int, height: Int) {
        gr.fillRect(x, y, width, height)
    }

    override fun clearRect(x: Int, y: Int, width: Int, height: Int) {
        gr.clearRect(x, y, width, height)
    }

    override fun drawRoundRect(x: Int, y: Int, width: Int, height: Int, arcWidth: Int, arcHeight: Int) {
        gr.drawRoundRect(x, y, width, height, arcWidth, arcHeight)
    }

    override fun fillRoundRect(x: Int, y: Int, width: Int, height: Int, arcWidth: Int, arcHeight: Int) {
        gr.fillRoundRect(x, y, width, height, arcWidth, arcHeight)
    }

    override fun drawOval(x: Int, y: Int, width: Int, height: Int) {
        gr.drawOval(x, y, width, height)
    }

    override fun fillOval(x: Int, y: Int, width: Int, height: Int) {
        gr.fillOval(x, y, width, height)
    }

    override fun drawArc(x: Int, y: Int, width: Int, height: Int, startAngle: Int, arcAngle: Int) {
        gr.drawArc(x, y, width, height, startAngle, arcAngle)
    }

    override fun fillArc(x: Int, y: Int, width: Int, height: Int, startAngle: Int, arcAngle: Int) {
        gr.fillArc(x, y, width, height, startAngle, arcAngle)
    }

    override fun drawPolyline(xPoints: IntArray?, yPoints: IntArray?, nPoints: Int) {
        gr.drawPolyline(xPoints, yPoints, nPoints)
    }

    override fun drawPolygon(xPoints: IntArray?, yPoints: IntArray?, nPoints: Int) {
        gr.drawPolygon(xPoints, yPoints, nPoints)
    }

    override fun fillPolygon(xPoints: IntArray?, yPoints: IntArray?, nPoints: Int) {
        gr.fillPolygon(xPoints, yPoints, nPoints)
    }

    override fun drawString(str: String, x: Int, y: Int) {
        gr.drawString(str, x, y)
    }

    override fun drawString(str: String?, x: Float, y: Float) {
        gr.drawString(str, x, y)
    }

    override fun drawString(iterator: AttributedCharacterIterator?, x: Int, y: Int) {
        gr.drawString(iterator, x, y)
    }

    override fun drawString(iterator: AttributedCharacterIterator?, x: Float, y: Float) {
        gr.drawString(iterator, x, y)
    }

    override fun drawImage(img: Image?, xform: AffineTransform?, obs: ImageObserver?): Boolean {
        return gr.drawImage(img, xform, obs)
    }

    override fun drawImage(img: BufferedImage?, op: BufferedImageOp?, x: Int, y: Int) {
        gr.drawImage(img, op, x, y)
    }

    override fun drawImage(img: Image?, x: Int, y: Int, observer: ImageObserver?): Boolean {
        return gr.drawImage(img, x, y, observer)
    }

    override fun drawImage(img: Image?, x: Int, y: Int, width: Int, height: Int, observer: ImageObserver?): Boolean {
        return gr.drawImage(img, x, y, width, height, observer)
    }

    override fun drawImage(img: Image?, x: Int, y: Int, bgcolor: Color?, observer: ImageObserver?): Boolean {
        return gr.drawImage(img, x, y, bgcolor, observer)
    }

    override fun drawImage(
        img: Image?,
        x: Int,
        y: Int,
        width: Int,
        height: Int,
        bgcolor: Color?,
        observer: ImageObserver?
    ): Boolean {
        return gr.drawImage(img, x, y, width, height, bgcolor, observer)
    }

    override fun drawImage(
        img: Image?,
        dx1: Int,
        dy1: Int,
        dx2: Int,
        dy2: Int,
        sx1: Int,
        sy1: Int,
        sx2: Int,
        sy2: Int,
        observer: ImageObserver?
    ): Boolean {
        return gr.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
    }

    override fun drawImage(
        img: Image?,
        dx1: Int,
        dy1: Int,
        dx2: Int,
        dy2: Int,
        sx1: Int,
        sy1: Int,
        sx2: Int,
        sy2: Int,
        bgcolor: Color?,
        observer: ImageObserver?
    ): Boolean {
        return gr.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer)
    }

    override fun dispose() {
        gr.dispose()
    }

    override fun draw(s: Shape?) {
        gr.draw(s)
    }

    override fun drawRenderedImage(img: RenderedImage?, xform: AffineTransform?) {
        gr.drawRenderedImage(img, xform)
    }

    override fun drawRenderableImage(img: RenderableImage?, xform: AffineTransform?) {
        gr.drawRenderableImage(img, xform)
    }

    override fun drawGlyphVector(g: GlyphVector?, x: Float, y: Float) {
        gr.drawGlyphVector(g, x, y)
    }

    override fun fill(s: Shape?) {
        gr.fill(s)
    }

    override fun hit(rect: Rectangle?, s: Shape?, onStroke: Boolean): Boolean {
        return gr.hit(rect, s, onStroke)
    }

    override fun getDeviceConfiguration(): GraphicsConfiguration {
        return gr.deviceConfiguration
    }

    override fun setComposite(comp: Composite?) {
        gr.composite = comp
    }

    override fun setPaint(paint: Paint?) {
        gr.paint = paint
    }

    override fun setStroke(s: Stroke?) {
        gr.stroke = s
    }

    override fun setRenderingHint(hintKey: RenderingHints.Key?, hintValue: Any?) {
        gr.renderingHints[hintKey] = hintValue
    }

    override fun getRenderingHint(hintKey: RenderingHints.Key?): Any {
        return gr.getRenderingHint(hintKey)
    }

    override fun setRenderingHints(hints: MutableMap<*, *>?) {
        gr.setRenderingHints(hints)
    }

    override fun addRenderingHints(hints: MutableMap<*, *>?) {
        gr.addRenderingHints(hints)
    }

    override fun getRenderingHints(): RenderingHints {
        return gr.renderingHints
    }

    override fun rotate(theta: Double) {
        gr.rotate(theta)
    }

    override fun rotate(theta: Double, x: Double, y: Double) {
        gr.rotate(theta, x, y)
    }

    override fun scale(sx: Double, sy: Double) {
        gr.scale(sx, sy)
    }

    override fun shear(shx: Double, shy: Double) {
        gr.shear(shx, shy)
    }

    override fun transform(Tx: AffineTransform?) {
        gr.transform(Tx)
    }

    override fun setTransform(Tx: AffineTransform?) {
        gr.transform = Tx
    }

    override fun getTransform(): AffineTransform {
        return gr.transform
    }

    override fun getPaint(): Paint {
        return gr.paint
    }

    override fun getComposite(): Composite {
        return gr.composite
    }

    override fun setBackground(color: Color?) {
        gr.background = color
    }

    override fun getBackground(): Color {
        return gr.background
    }

    override fun getStroke(): Stroke {
        return gr.stroke
    }

    override fun clip(s: Shape?) {
        gr.clip(s)
    }

    override fun getFontRenderContext(): FontRenderContext {
        return gr.fontRenderContext
    }
}
