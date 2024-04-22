package com.trading.quotes.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TradingQuotesResponse(
    @SerialName("ClosePrice")
    val ClosePrice: Int,
    @SerialName("TradingReferencePrice")
    val TradingReferencePrice: Int,
    @SerialName("TradingSessionSubID")
    val TradingSessionSubID: String,
    @SerialName("acd")
    val acd: Int,
    @SerialName("baf")
    val baf: Int,
    @SerialName("bap")
    val bap: Double,
    @SerialName("bas")
    val bas: Int,
    @SerialName("base_contract_code")
    val base_contract_code: String,
    @SerialName("base_currency")
    val base_currency: String,
    @SerialName("base_ltr")
    val base_ltr: String,
    @SerialName("bbf")
    val bbf: Int,
    @SerialName("bbp")
    val bbp: Double,
    @SerialName("bbs")
    val bbs: Int,
    @SerialName("val c")
    val c: String,
    @SerialName("chg")
    val chg: Double,
    @SerialName("chg110")
    val chg110: Double,
    @SerialName("chg22")
    val chg22: Double,
    @SerialName("chg220")
    val chg220: Double,
    @SerialName("chg5")
    val chg5: Double,
    @SerialName("codesub_nm")
    val codesub_nm: String,
    @SerialName("cpn")
    val cpn: Int,
    @SerialName("cpp")
    val cpp: Int,
    @SerialName("dpb")
    val dpb: Int,
    @SerialName("dps")
    val dps: Int,
    @SerialName("fv")
    val fv: Int,
    @SerialName("val `")
    val `init`: Int,
    @SerialName("issue_nb")
    val issue_nb: String,
    @SerialName("kind")
    val kind: Int,
    @SerialName("ltp")
    val ltp: Double,
    @SerialName("ltr")
    val ltr: String,
    @SerialName("lts")
    val lts: Int,
    @SerialName("ltt")
    val ltt: String,
    @SerialName("marketStatus")
    val marketStatus: String,
    @SerialName("maxtp")
    val maxtp: Double,
    @SerialName("min_step")
    val min_step: Double,
    @SerialName("mintp")
    val mintp: Double,
    @SerialName("mrg")
    val mrg: String,
    @SerialName("mtd")
    val mtd: String,
    @SerialName("val n")
    val n: Int,
    @SerialName("name")
    val name: String,
    @SerialName("name2")
    val name2: String,
    @SerialName("ncd")
    val ncd: String,
    @SerialName("ncp")
    val ncp: Int,
    @SerialName("op")
    val op: Double,
    @SerialName("otc_instr")
    val otc_instr: String,
    @SerialName("p110")
    val p110: Double,
    @SerialName("p22")
    val p22: Double,
    @SerialName("p220")
    val p220: Double,
    @SerialName("p5")
    val p5: Double,
    @SerialName("pcp")
    val pcp: Double,
    @SerialName("pp")
    val pp: Double,
    @SerialName("rev")
    val rev: Int,
    @SerialName("scheme_calc")
    val scheme_calc: String,
    @SerialName("step_price")
    val step_price: Double,
    @SerialName("trades")
    val trades: Int,
    @SerialName("type")
    val type: Int,
    @SerialName("virt_base_instr")
    val virt_base_instr: String,
    @SerialName("vlt")
    val vlt: Double,
    @SerialName("vol")
    val vol: Int,
    @SerialName("x_curr")
    val x_curr: String,
    @SerialName("x_currVal")
    val x_currVal: Double,
    @SerialName("x_descr")
    val x_descr: String,
    @SerialName("x_dsc1")
    val x_dsc1: Int,
    @SerialName("x_dsc2")
    val x_dsc2: Int,
    @SerialName("x_dsc3")
    val x_dsc3: Int,
    @SerialName("x_istrade")
    val x_istrade: Int,
    @SerialName("x_lot")
    val x_lot: Int,
    @SerialName("x_max")
    val x_max: Double,
    @SerialName("x_min")
    val x_min: Int,
    @SerialName("x_short")
    val x_short: Int,
    @SerialName("yld")
    val yld: String,
    @SerialName("yld_ytm_ask")
    val yld_ytm_ask: Int,
    @SerialName("yld_ytm_bid")
    val yld_ytm_bid: Int
)
