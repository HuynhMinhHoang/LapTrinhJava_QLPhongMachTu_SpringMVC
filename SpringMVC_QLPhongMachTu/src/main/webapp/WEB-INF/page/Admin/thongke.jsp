<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<main class="table">
    <div class="textThongKe">
        <h1>THỐNG KÊ BỆNH NHÂN</h1>
    </div>

    <nav class="container_TK">
        <div class="TK_Thang">
            <h2>Thống Kê Theo Tháng: </h2>
            <form action="${pageContext.request.contextPath}/admin/thongke" method="post">
                <label for="year">Chọn năm:</label>
                <select id="year" name="year">
                    <c:forEach var="year" begin="2020" end="2030">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>
                <br>
                <label for="month">Chọn tháng:</label>
                <select id="month" name="month">
                    <c:forEach var="month" begin="1" end="12">
                        <option value="${month}">${month}</option>
                    </c:forEach>
                </select>
                <br>
                <button type="submit">Thống kê</button>
            </form>
            <canvas id="monthlyRevenueChart" class="circle-chart"></canvas>
        </div>

        <div class="TK_Quy">
            <h2>Thống Kê Theo Quý: </h2>
            <form action="${pageContext.request.contextPath}/admin/thongke" method="post">
                <label for="year">Chọn năm:</label>
                <select id="year" name="year">
                    <c:forEach var="year" begin="2020" end="2030">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>
                <br>
                <label for="quarter">Chọn quý:</label>
                <select id="quarter" name="quarter">
                    <c:forEach var="quarter" begin="1" end="4">
                        <option value="${quarter}">${quarter}</option>
                    </c:forEach>
                </select>
                <br>
                <button type="submit">Thống kê</button>
            </form>
            <canvas id="quarterlyRevenueChart" class="circle-chart"></canvas>
        </div>
    </nav>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawCharts);

        var benhNhanCount = ${countBenhNhan};
        var trangThaiKhamCount = ${countTrangThaiKham};

        function drawCharts() {
            drawCircleChart('monthlyRevenueChart', 'Thống kê số lượng theo tháng', benhNhanCount, trangThaiKhamCount);
            drawCircleChart('quarterlyRevenueChart', 'Thống kê số lượng theo quý', benhNhanCount, trangThaiKhamCount);
            drawColumnChart();
        }

        function drawCircleChart(chartId, chartTitle, benhNhanCount, trangThaiKhamCount) {
            var data = google.visualization.arrayToDataTable([
                ['Loại', 'Số lượng'],
                ['Bệnh Nhân Chưa Khám', benhNhanCount],
                ['Bệnh Nhân Đã Khám', trangThaiKhamCount]
            ]);

            var options = {
                title: chartTitle,
                bars: 'vertical'
            };

            var chart = new google.visualization.PieChart(document.getElementById(chartId));
            chart.draw(data, options);
        }

        function drawColumnChart() {
            var data = google.visualization.arrayToDataTable([
                ['Loại', 'Số lượng'],
                ['Bệnh Nhân Chưa Khám', benhNhanCount],
                ['Bệnh Nhân Đã Khám', trangThaiKhamCount]
            ]);

            var options = {
                title: 'Biểu đồ cột thống kê số lượng',
                bars: 'vertical'
            };

            var chart = new google.visualization.ColumnChart(document.getElementById('columnChartContainer'));
            chart.draw(data, options);
        }
    </script>

    <div id="columnChartContainer"></div>
</main>
