class DisplaydataController < ApplicationController
  before_action :set_displaydatum, only: [:show, :edit, :update, :destroy]

  # GET /displaydata
  # GET /displaydata.json
  def index
    @displaydata = Displaydatum.all
  end

  # GET /displaydata/1
  # GET /displaydata/1.json
  def show
  end

  # GET /displaydata/new
  def new
    @displaydatum = Displaydatum.new
  end

  # GET /displaydata/1/edit
  def edit
  end

  # POST /displaydata
  # POST /displaydata.json
  def create
    @displaydatum = Displaydatum.new(displaydatum_params)

    respond_to do |format|
      if @displaydatum.save
        format.html { redirect_to @displaydatum, notice: 'Displaydatum was successfully created.' }
        format.json { render :show, status: :created, location: @displaydatum }
      else
        format.html { render :new }
        format.json { render json: @displaydatum.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /displaydata/1
  # PATCH/PUT /displaydata/1.json
  def update
    respond_to do |format|
      if @displaydatum.update(displaydatum_params)
        format.html { redirect_to @displaydatum, notice: 'Displaydatum was successfully updated.' }
        format.json { render :show, status: :ok, location: @displaydatum }
      else
        format.html { render :edit }
        format.json { render json: @displaydatum.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /displaydata/1
  # DELETE /displaydata/1.json
  def destroy
    @displaydatum.destroy
    respond_to do |format|
      format.html { redirect_to displaydata_url, notice: 'Displaydatum was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_displaydatum
      @displaydatum = Displaydatum.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def displaydatum_params
      params.require(:displaydatum).permit(:infodate, :hour, :positive, :neutral, :negative, :cloud, :image_loc)
    end
end
